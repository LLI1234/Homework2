package org.example.homework2.Repository;

import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.example.homework2.Entity.Student;
import org.example.homework2.Entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Transactional
    public Student save(Student student, Long id) {
        student.setId(id);
        entityManager.persist(student);
        return student;
    }

    @Transactional
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Transactional
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    @Transactional
    public Student update(Student student, Long id) {
        Student newStudent = save(student, id);
        return entityManager.merge(newStudent);
    }

    @Transactional
    public void deleteById(Long id) {
        Student student = findById(id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Transactional
    public List<Student> joinStudentTeacher(Student student) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> studentRoot = cq.from(Student.class);
        Join<Student, Teacher> studentTeacherJoin = studentRoot.join("studentTeachers");
        studentTeacherJoin.join("Teachers");
        cq.select(studentRoot).where(cb.greaterThan(studentRoot.get("id"), 10));
        return entityManager.createQuery(cq).getResultList();
    }
}
