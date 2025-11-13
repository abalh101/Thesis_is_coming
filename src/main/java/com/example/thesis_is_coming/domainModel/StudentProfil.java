package com.example.thesis_is_coming.domainModel;

import java.util.List;
//Entity and Aggregatroot

public record StudentProfil(
        Integer studentID,
        String StudentName,
        KontaktInfo kontaktInfo,
        List<Fachgebiet> intersse,
        List<Modules> bestandeneModulle
) {

}
