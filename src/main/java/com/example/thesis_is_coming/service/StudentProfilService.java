package com.example.thesis_is_coming.service;

import com.example.thesis_is_coming.domainModel.StudentProfil;
import com.example.thesis_is_coming.service.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfilService {

    private final StudentRepository studentRepository;

    public StudentProfilService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional <StudentProfil> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public StudentProfil save(StudentProfil studentProfil) {
        return studentRepository.save(studentProfil);
    }
    public List<StudentProfil> findAll() {
        return studentRepository.findAll();
    }
}
