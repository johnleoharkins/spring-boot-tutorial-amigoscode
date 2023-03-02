package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Contains all resources for Student API
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    /**
     * @Autowire annotation connects the injected StudentService with the reference above
     * @param studentService
     */
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    /**
     * GET mapping for the Student controller
     * @return List of students
     */
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
