package org.example.homework2.Service;

import java.util.*;
import org.example.homework2.Entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    Student save(Student student);
    Student save(Student student, Long id);
    Student findById(Long id);
    List<Student> findAll();
    Student update(Student student, Long id);
    void deleteById(Long id);
    List<Student> joinStudentTeacher(Student student);
}
