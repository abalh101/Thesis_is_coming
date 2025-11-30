package com.example.thesis_is_coming.service.repository;

import com.example.thesis_is_coming.domainModel.themen.Themen;

import java.util.List;
import java.util.Optional;

public interface ThemenRepository {
    Themen saveThemen(Themen themen);
    List<Themen> findAll();
    Optional<Themen> findById(Integer themenID);

}
