package com.example.thesis_is_coming.controller.betreuerContoller;


import com.example.thesis_is_coming.domainModel.BetreuerProfil;
import com.example.thesis_is_coming.domainModel.Fachgebiet;
import com.example.thesis_is_coming.domainModel.KontaktInfo;
import com.example.thesis_is_coming.domainModel.Link;
import com.example.thesis_is_coming.service.BetreuerProfilService;
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
public class BetreuerController {
    private final BetreuerProfilService betreuerProfilService;

    @Autowired
    public BetreuerController(BetreuerProfilService betreuerProfilService) {
        this.betreuerProfilService = betreuerProfilService;
    }

    //Formular anzeigen
    @GetMapping("/neu")
    public String createBetruer(Model model) {
        model.addAttribute("betreuerForm" , new BetreuerForm());
        return "betreuer/Betreuer-form";
    }

    //speichern
    @PostMapping("/neu")
    public String saveBetreuer(@ModelAttribute("betreuerForm") BetreuerForm form) {


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
                List.of(),
                kontaktInfo,
                fachgebieteList,
                List.of(), // Leere Liste für Dateien da noch kein File-Upload implementiert
                linkList
        );

        betreuerProfilService.save(profil);

        return "redirect:/betreuer/alle";
    }

    @GetMapping("/alle")
    public String list(Model model) {
        model.addAttribute("betreuer", betreuerProfilService.findAll());
        return "betreuer/Betreuer-liste";    }

    private Integer generateId() {
        return betreuerProfilService.findAll().size() + 1;
    }

}
