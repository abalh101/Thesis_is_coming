package com.example.thesis_is_coming.service;

import com.example.thesis_is_coming.domainModel.betreuer.BetreuerProfil;
import com.example.thesis_is_coming.service.repository.BetreuerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetreuerProfilService {

    private final BetreuerRepository betreuerRepository;

    public BetreuerProfilService(BetreuerRepository betreuerRepository) {
        this.betreuerRepository = betreuerRepository;
    }

    public BetreuerProfil save(BetreuerProfil betreuerProfil) {
        return betreuerRepository.save(betreuerProfil);
    }
    public Optional<BetreuerProfil> findById(Integer betreuerId) {
        return betreuerRepository.findById(betreuerId);
    }

    public List<BetreuerProfil> findAll() {
        return betreuerRepository.findAll();
    }
}
