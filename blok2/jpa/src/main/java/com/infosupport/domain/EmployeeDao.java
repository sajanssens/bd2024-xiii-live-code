package com.infosupport.domain;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class EmployeeDao extends Dao {

    public EmployeeDao(EntityManager em) { super(em); }

    // CRUD:
    public void create(Employee emp) { consumeTransaction(em::persist, emp); }

    public Employee read(int id) { return em.find(Employee.class, id); }

    public Employee update(Employee e) { return performTransaction(em::merge, e); }

    public void delete(Employee e) { consumeTransaction(em::remove, e); }

    // QUERIES:
    public List<Employee> findBy(String name) {
        return em.createQuery("select e from Employee e where e.name = :n", Employee.class)
                .setParameter("n", name)
                .getResultList();
    }
}
