package com.infosupport.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeDao {

    private final EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    public void save(Employee e) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(e);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            log.error(ex.getMessage(), ex);
        }
    }
}
