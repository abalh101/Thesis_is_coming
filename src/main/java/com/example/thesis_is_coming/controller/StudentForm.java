package com.example.thesis_is_coming.controller;

public class StudentForm {
    private String name;
    private String email;
    private String rufnummer;
    private String interssen; //kommaseparierte zb java,web,
    private String bestandeneModulle; // kommaseparierte


    public StudentForm() {

    }
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
    public String getInterssen() {
        return interssen;
    }
    public void setInterssen(String interssen) {
        this.interssen = interssen;
    }
    public String getBestandeneModulle() {
        return bestandeneModulle;
    }
    public void setBestandeneModulle(String bestandeneModulle) {
        this.bestandeneModulle = bestandeneModulle;
    }

}
