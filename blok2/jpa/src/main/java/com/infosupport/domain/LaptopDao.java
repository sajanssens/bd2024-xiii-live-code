package com.infosupport.domain;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class LaptopDao extends Dao {

    public LaptopDao(EntityManager em) { super(em); }

    // CRUD:
    public void create(Laptop emp) { consumeTransaction(em::persist, emp); }

    public Laptop read(int id) { return em.find(Laptop.class, id); }

    public Laptop update(Laptop e) { return performTransaction(em::merge, e); }

    public void delete(Laptop e) { consumeTransaction(em::remove, e); }

    public List<Laptop> findBy(String brand) {
        return em.createQuery("select e from Laptop e where e.brand = :b", Laptop.class)
                .setParameter("b", brand)
                .getResultList();
    }
}
