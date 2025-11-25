package com.example.thesis_is_coming.db;

import com.example.thesis_is_coming.domainModel.betreuer.BetreuerProfil;
import com.example.thesis_is_coming.service.repository.BetreuerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository// DB muss als Repository annotiert werden
public class InMemoryBetreuerRepository implements BetreuerRepository {
    private final Map<Integer, BetreuerProfil> database = new ConcurrentHashMap<>();


    @Override
    public BetreuerProfil save(BetreuerProfil betreuerProfil) {
        database.put(betreuerProfil.betreuerID(),betreuerProfil);
        return betreuerProfil;

    }

    @Override
    public Optional<BetreuerProfil> findById(Integer betreuerID) {
        return Optional.ofNullable(database.get(betreuerID));
    }

    @Override
    public List<BetreuerProfil> findAll() {
        return new ArrayList<>(database.values());
    }
}
