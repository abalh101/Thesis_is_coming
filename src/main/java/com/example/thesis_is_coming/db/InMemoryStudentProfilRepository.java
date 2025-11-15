package com.example.thesis_is_coming.db;

import com.example.thesis_is_coming.service.repository.StudentRepository;
import com.example.thesis_is_coming.domainModel.StudentProfil;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class InMemoryStudentProfilRepository implements StudentRepository {
    private final Map<Integer, StudentProfil> database = new ConcurrentHashMap<>();

        @Override
        public StudentProfil save(StudentProfil studentProfil) {
        database.put(studentProfil.studentID(), studentProfil);
        return studentProfil;
        }

        @Override
        public Optional<StudentProfil> findById(Integer studentId) {
            return Optional.ofNullable(database.get(studentId));
        }
        @Override
        public List<StudentProfil> findAll() {
            return new ArrayList<>(database.values());
        }
}
