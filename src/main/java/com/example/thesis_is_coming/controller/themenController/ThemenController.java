package com.example.thesis_is_coming.controller.themenController;

import com.example.thesis_is_coming.service.StudentProfilService;
import com.example.thesis_is_coming.service.ThemenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/themen")
public class ThemenController {

    private final ThemenService themenService;
    private final StudentProfilService studentProfilService;

    @Autowired
    public ThemenController(ThemenService themenService, StudentProfilService studentProfilService) {
        this.themenService = themenService;
        this.studentProfilService = studentProfilService;
    }

    @GetMapping("/alle")
    public String list(Model model) {
        model.addAttribute("themen" , themenService.findAll());
        model.addAttribute("alleStudenten", studentProfilService.findAll());
        return "themen/themen-liste";
    }

    @PostMapping("/buchen")
    public String buchen(@RequestParam("themaID") Integer themaID,
                         @RequestParam("studentID") Integer studentID,
                         RedirectAttributes redirectAttributte) {

        try{
            themenService.themaBuchen(themaID, studentID);
            redirectAttributte.addFlashAttribute("succesMessage", "Thema erfolgreich gebucht!");
        } catch (Exception e) {
            redirectAttributte.addFlashAttribute("errorMessage", e.getMessage());
            //System.out.println("Fehler beim Buchen: " + e.getMessage());
        }
        return "redirect:/themen/alle";
    }

    @GetMapping("/neu")
    public String createForm(Model model) {
        model.addAttribute("themenForm" , new ThemenForm());
        return "themen/themen-form";
    }
    @PostMapping("/neu")
    public String saveThema(@ModelAttribute("themenForm") ThemenForm form) {
        themenService.createThma(
                form.getTitel(),
                form.getBeschreibung(),
                form.getBetreuerID()
        );
        return "redirect:/themen/alle";
    }

}