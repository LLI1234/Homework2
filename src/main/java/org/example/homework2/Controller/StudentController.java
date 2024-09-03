package org.example.homework2.Controller;

import java.util.*;
import org.example.homework2.Entity.Student;
import org.example.homework2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student student, @PathVariable Long id){
        return studentService.save(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @GetMapping("/student-teacher")
    public List<Student> joinStudentTeacher(@RequestBody Student student){
        return studentService.joinStudentTeacher(student);
    }
}
