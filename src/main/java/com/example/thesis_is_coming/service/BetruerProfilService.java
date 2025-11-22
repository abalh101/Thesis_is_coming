package com.example.thesis_is_coming.service;

import com.example.thesis_is_coming.domainModel.BetreuerProfil;
import com.example.thesis_is_coming.service.repository.BetruerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetruerProfilService {

    private final BetruerRepository betruerRepository;

    public BetruerProfilService(BetruerRepository betruerRepository) {
        this.betruerRepository = betruerRepository;
    }

    public BetreuerProfil save(BetreuerProfil betreuerProfil) {
        return betruerRepository.save(betreuerProfil);
    }
    public Optional<BetreuerProfil> findById(Integer betreuerId) {
        return betruerRepository.findById(betreuerId);
    }

    public List<BetreuerProfil> findAll() {
        return betruerRepository.findAll();
    }
}
