package com.example.thesis_is_coming.domainModel.student;

import com.example.thesis_is_coming.domainModel.Fachgebiet;
import com.example.thesis_is_coming.domainModel.KontaktInfo;
import com.example.thesis_is_coming.domainModel.Modules;

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
