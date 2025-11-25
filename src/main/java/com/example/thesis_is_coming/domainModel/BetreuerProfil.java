package com.example.thesis_is_coming.domainModel;

import java.util.List;



public record BetreuerProfil(
        Integer betreuerID,
        String betreuerName,
        KontaktInfo kontaktInfo,
        List<Fachgebiet> fachgebiete,
        List<Datei> datei,
        List<Link> profilLinks
){

}
