package com.nicolasbolt.lmsapi.controllers;

import com.nicolasbolt.lmsapi.models.Student;
import com.nicolasbolt.lmsapi.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();
        studentService.findAllStudents().forEach(students::add);

        return students;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(studentService.findById(id).get());
    }
}
