package com.nicolasbolt.lmsapi.services;


import com.nicolasbolt.lmsapi.models.Student;
import com.nicolasbolt.lmsapi.repositories.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentsRepository studentsRepository;

    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Iterable<Student> findAllStudents() {
        return studentsRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentsRepository.findById(id);
    }

    public void addStudent(Student student) {
        studentsRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentsRepository.save(student);
    }

    public void deleteStudent(Student student) {
        studentsRepository.delete(student);
    }


}
