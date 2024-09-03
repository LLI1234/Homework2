package org.example.homework2.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.example.homework2.Entity.Student;
import org.example.homework2.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{

    // This or @Autowired repo?
    @Autowired
    private StudentRepo studentRepo;

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    @Transactional
    public Student save(Student student, Long id) {
        return studentRepo.save(student, id);
    }

    @Transactional
    public Student findById(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    @Transactional
    public Student update(Student student, Long id) {
        return studentRepo.update(student, id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    @Transactional
    public List<Student> joinStudentTeacher(Student student) {
        return studentRepo.joinStudentTeacher(student);
    }
}
