package com.example.thesis_is_coming.service.repository;

import com.example.thesis_is_coming.domainModel.StudentProfil;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    StudentProfil save(StudentProfil studentProfil);
    Optional<StudentProfil> findById(Integer id);
    List<StudentProfil> findAll();
}
