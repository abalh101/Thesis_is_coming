package com.example.thesis_is_coming.controller.betreuerContoller;

import com.example.thesis_is_coming.domainModel.KontaktInfo;

public class  BetruerForm {
    private String name;
    private String email;
    private String rufnummer;
    private String fachgebiete; // Kommasepariert: "KI, Web, Security"
    private String profilLinks; // Kommasepariert: "linkedin.com/in/xyz, github.com/xyz"


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRufnummer() {
        return rufnummer;
    }

    public void setRufnummer(String rufnummer) {
        this.rufnummer = rufnummer;
    }

    public String getFachgebiete() {
        return fachgebiete;
    }

    public void setFachgebiete(String fachgebiete) {
        this.fachgebiete = fachgebiete;
    }

    public String getProfilLinks() {
        return profilLinks;
    }

    public void setProfilLinks(String profilLinks) {
        this.profilLinks = profilLinks;
    }
}