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
        Integer betreuerID, // Referenz zum Betreuer per ID
        String titel,
        Optional<String> beschreibung,
        List<Datei> datei,
        List<Fachgebiet> fachgebiete,
        List<Modules> anforderungen,
        List<Link> link
) {

};

