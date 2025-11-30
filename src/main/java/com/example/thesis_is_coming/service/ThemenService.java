package com.example.thesis_is_coming.service;

import com.example.thesis_is_coming.domainModel.themen.Themen;
import com.example.thesis_is_coming.service.repository.ThemenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemenService {
    private final ThemenRepository themenRepository;

    @Autowired
    public ThemenService(ThemenRepository themenRepository) {
        this.themenRepository = themenRepository;
    }

    public List<Themen> findAll() {
        return themenRepository.findAll();
    }
    public void themaBuchen(Integer themaId, Integer studentID) {

        boolean hatSchonEinThema = themenRepository.findAll()
                .stream()
                .anyMatch(t -> t.istVergeben() && t.assignedStudentID().equals(studentID));
        if(hatSchonEinThema) {
            throw new IllegalStateException("Dieser Student hat bereits ein Thema belegt!");
        }

        Themen altesThema = themenRepository.findById(themaId)
                .orElseThrow(() -> new IllegalArgumentException("Thema nicht gefunden!"));

        Themen neuesThema = altesThema.vergebenAn(studentID);
        themenRepository.saveThemen(neuesThema);
    }

    public void createThma(String titel, String beschreibung , Integer betreuerID) {
        Integer newID = findAll().size() + 1;
         Themen neuesThema = new Themen(
                 newID,
                 null,
                 betreuerID,
                 titel,
                 Optional.ofNullable(beschreibung),
                 List.of(),
                 List.of(),
                 List.of(),
                 List.of()
         );
         themenRepository.saveThemen(neuesThema);
    };
}
