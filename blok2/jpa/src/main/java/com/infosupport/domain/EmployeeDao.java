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

    public List<Employee> findWithNamedQueryBy(String name) {
        return em.createNamedQuery("Employee.findByName", Employee.class)
                .setParameter("n", name)
                .getResultList();
    }

    public void deleteAll() {
        consumeTransaction(() -> em.createQuery("DELETE Employee e").executeUpdate());
    }

    public List<Laptop> findLaptopsOf(long id) {
        return em.createQuery("select l from Laptop l where l.employee.id = :i ", Laptop.class)
                .setParameter("i", id)
                .getResultList();
    }

    public Employee findWithLaptops(long id) {
        return em.createQuery("select e from Employee e join fetch e.laptops where e.id = :i ", Employee.class)
                .setParameter("i", id)
                .getSingleResult();
    }


}
