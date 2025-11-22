package com.example.thesis_is_coming.controller.betreuerContoller;


import com.example.thesis_is_coming.domainModel.BetreuerProfil;
import com.example.thesis_is_coming.domainModel.Fachgebiet;
import com.example.thesis_is_coming.domainModel.KontaktInfo;
import com.example.thesis_is_coming.domainModel.Link;
import com.example.thesis_is_coming.service.BetruerProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/betreuer")
public class BetruerController {
    private final BetruerProfilService betruerProfilService;

    @Autowired
    public BetruerController(BetruerProfilService betruerProfilService) {
        this.betruerProfilService = betruerProfilService;
    }

    //Formular anzeigen
    @GetMapping("/neu")
    public String createBetruer(Model model) {
        model.addAttribute("betreuerForm" , new BetruerForm());
        return "betruer/Betreuer-form";
    }

    //speichern
    @PostMapping("/neu")
    public String saveBetreuer(@ModelAttribute("betreuerForm") BetruerForm form) {


        KontaktInfo kontaktInfo = new KontaktInfo(form.getEmail(), form.getRufnummer());


        List<Fachgebiet> fachgebieteList = Arrays.stream(form.getFachgebiete().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Fachgebiet::new) // Konstruktor von Fachgebiet aufrufen
                .collect(Collectors.toList());

        List<Link> linkList = Arrays.stream(form.getProfilLinks().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(url -> new Link(url , url)) // links erwartet 2 Argumente
                .collect(Collectors.toList());


        BetreuerProfil profil = new BetreuerProfil(
                generateId(),
                form.getName(),
                kontaktInfo,
                fachgebieteList,
                List.of(), // Leere Liste für Dateien da noch kein File-Upload implementiert
                linkList
        );

        betruerProfilService.save(profil);

        return "redirect:/betreuer/alle";
    }

    @GetMapping("/alle")
    public String list(Model model) {
        model.addAttribute("betreuer", betruerProfilService.findAll());
        return "betruer/Betreuer-liste";    }

    private Integer generateId() {
        return betruerProfilService.findAll().size() + 1;
    }

}
