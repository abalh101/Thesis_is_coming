package com.example.thesis_is_coming.domainModel.themen;

import com.example.thesis_is_coming.domainModel.Datei;
import com.example.thesis_is_coming.domainModel.Fachgebiet;
import com.example.thesis_is_coming.domainModel.Link;
import com.example.thesis_is_coming.domainModel.Modules;

import java.util.List;
import java.util.Optional;


// Aggregate

public record Themen(
        Integer ID,
        Integer assignedStudentID,
        Integer betreuerID, // Referenz zum Betreuer per ID
        String titel,
        Optional<String> beschreibung,
        List<Datei> datei,
        List<Fachgebiet> fachgebiete,
        List<Modules> anforderungen,
        List<Link> link
) {

    public boolean istVergeben() {
        return assignedStudentID != null;
    }
    //records sind immutable deswegen ersetzten wir das Objekt


    public Themen vergebenAn(Integer studentID) {
        if(this.istVergeben()) {
            throw new IllegalStateException("Das Thema ist bereits vergeben");

        }
        return new Themen(
                this.ID,
                studentID,
                this.betreuerID,
                this.titel,
                this.beschreibung,
                this.datei,
                this.fachgebiete,
                this.anforderungen,
                this.link

        );
    }
};

