package com.infosupport.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class EmployeeDao {

    private final EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    public void create(Employee e) {
        log.info("Employee before save is " + (em.contains(e) ? "" : "not ") + "managed.");

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(e);
            log.info("Employee after persist is " + (em.contains(e) ? "" : "not ") + "managed.");
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            log.error(ex.getMessage(), ex);
        }
        log.info("Employee after save is " + (em.contains(e) ? "" : "not ") + "managed.");
    }

    public Employee read(int id) {
        return em.find(Employee.class, id);
    }

    public Employee update(Employee e) {
        Employee mergedE = e;
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            mergedE = em.merge(e);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            log.error(ex.getMessage(), ex);
        }
        return mergedE;
    }

    public void delete(Employee e) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(e);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            log.error(ex.getMessage(), ex);
        }
    }

    public List<Employee> findBy(String name) {
        return em.createQuery("select e from Employee e where e.name = :n", Employee.class)
                .setParameter("n", name)
                .getResultList();
    }
}
