package org.lessons.lesson31.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.lessons.lesson31.dto.Student;

import java.util.List;

public class StudentDaoImpl implements GenericDao<Student, Long> {

    private final EntityManager entityManager;

    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void save(Student entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    @Override
    public Student findById(Long aLong) {
        return entityManager.find(Student.class, aLong);
    }

    @Override
    public Student findByEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student update(Student entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Student merged = entityManager.merge(entity);
        transaction.commit();
        return merged;
    }

    @Override
    public boolean deleteById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Student student = entityManager.find(Student.class, id);
            if (student != null) {
                entityManager.remove(student);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
    }
}

