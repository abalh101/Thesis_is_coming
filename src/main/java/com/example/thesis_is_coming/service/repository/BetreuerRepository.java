package com.example.thesis_is_coming.service.repository;

import com.example.thesis_is_coming.domainModel.betreuer.BetreuerProfil;

import java.util.List;
import java.util.Optional;

public interface BetreuerRepository {

    BetreuerProfil save(BetreuerProfil betreuerProfil);
    Optional<BetreuerProfil> findById(Integer betreuerId);
    List<BetreuerProfil> findAll();
}
