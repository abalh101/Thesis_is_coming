package com.example.thesis_is_coming.controller;


import com.example.thesis_is_coming.domainModel.Fachgebiet;
import com.example.thesis_is_coming.domainModel.KontaktInfo;
import com.example.thesis_is_coming.domainModel.Modules;
import com.example.thesis_is_coming.domainModel.StudentProfil;
import com.example.thesis_is_coming.service.StudentProfilService;
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
@RequestMapping("/profil")
public class StudentController {

    private final StudentProfilService studentProfilService;
    @Autowired
    public StudentController(StudentProfilService studentProfilService) {
        this.studentProfilService = studentProfilService;
    }

    //  Formular anzeigen
    @GetMapping("/neu")
    public String createForm(Model model) {
        model.addAttribute("studentForm", new StudentForm());
        /* Ein leeres StudentForm ist notwendig damit html das Formular mit Thymlief bindet
        * ohne new StudentForm wird ein Fehler geworfen, weil StudentFrom nicht existiert
        * Also Modelattribute verbindet html und objekt*/
        return "profil-form";
    }

    //  Speichern
    @PostMapping("/neu")
    public String saveProfil(@ModelAttribute("studentForm") StudentForm form) {
        //@ModelAttribute sagt Spring hol die Daten aus der dem Formular und füll das Studentobjekt
        KontaktInfo kontaktInfo = new KontaktInfo(form.getEmail(), form.getRufnummer());

        List<Fachgebiet> interessenList = Arrays.stream(form.getInterssen().split(","))
                .map(String::trim) // String::trim entfernt leerZeichen
                .filter(s -> !s.isEmpty()) // Falls zwischen den den Kommas leer ist entferne es
                .map(Fachgebiet::new)// Fpr jedes Wort ein Fachgebiet erstellen
                .collect(Collectors.toList());

        List<Modules> modulList = Arrays.stream(form.getBestandeneModulle().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                    .map(Modules::new)
                .collect(Collectors.toList());

        StudentProfil profil = new StudentProfil(
                generateId(),      // spöter von der Datenbank
                form.getName(),
                kontaktInfo,
                interessenList,
                modulList
        );

        studentProfilService.save(profil);
        return "redirect:/profil/alle";
    }

    @GetMapping("/alle")
    public String list(Model model) {
        model.addAttribute("studenten", studentProfilService.findAll());
        return "profil-liste";
    }

    // Id -> später durch die Datenbank ersetzt
    private Integer generateId() {
        return studentProfilService.findAll().size() + 1;
    }
}
