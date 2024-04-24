package com.infosupport.domain;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.infosupport.domain.Dao.consumeTransaction;
import static com.infosupport.domain.Dao.performTransaction;

@Slf4j
public class EmployeeDao {

    private final EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    // CRUD:
    public void create(Employee emp) { consumeTransaction(em, em::persist, emp); }

    public Employee read(int id) { return em.find(Employee.class, id); }

    public Employee update(Employee e) { return performTransaction(em, em::merge, e); }

    public void delete(Employee e) { consumeTransaction(em, em::remove, e); }

    // QUERIES:
    public List<Employee> findBy(String name) {
        return em.createQuery("select e from Employee e where e.name = :n", Employee.class)
                .setParameter("n", name)
                .getResultList();
    }


}
