package com.example.thesis_is_coming.domainModel;

import java.util.List;
//Entity and Aggregatroot

public record StudentProfil(
        Integer studentID,
        String studentName,
        KontaktInfo kontaktInfo,
        List<Fachgebiet> interessen,
        List<Modules> bestandeneModule
) {

}
