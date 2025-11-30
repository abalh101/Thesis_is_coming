package com.example.thesis_is_coming.db;

import com.example.thesis_is_coming.domainModel.themen.Themen;
import com.example.thesis_is_coming.service.repository.ThemenRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryThemen implements ThemenRepository {
    private final Map<Integer, Themen> database = new ConcurrentHashMap<>();

    @Override
    public Themen saveThemen(Themen themen) {
        database.put(themen.ID(), themen);
        return themen;
    }

    @Override
    public List<Themen> findAll() {
        return new ArrayList<> (database.values());
    }

    @Override
    public Optional<Themen> findById(Integer themenID) {
        return Optional.ofNullable(database.get(themenID));
    }
}
