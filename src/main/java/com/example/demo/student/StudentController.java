package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Register a new student
     * @param student mapped from request body
     */
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    /**
     * Delete a student by id
     * @param studentId of the Student to delete
     */
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    /**
     * Update an existing student
     * @param studentId of the student to update
     * @param name name of the student
     * @param email email of the student
     */
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}
