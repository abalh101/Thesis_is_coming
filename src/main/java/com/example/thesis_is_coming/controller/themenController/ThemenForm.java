package com.example.thesis_is_coming.controller.themenController;

public class ThemenForm {
    private String titel;
    private String beschreibung;
    private Integer betreuerID;

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }

    public Integer getBetreuerID() { return betreuerID; }
    public void setBetreuerID(Integer betreuerID) { this.betreuerID = betreuerID; }
}
