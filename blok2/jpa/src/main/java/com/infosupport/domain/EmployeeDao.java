package com.infosupport.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public class EmployeeDao {

    private final EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    public void create(Employee emp) { consumeTransaction(em::persist, emp); }

    public Employee read(int id) { return em.find(Employee.class, id); }

    public Employee update(Employee e) { return performTransaction(em::merge, e); }

    public void delete(Employee e) { consumeTransaction(em::remove, e); }

    public List<Employee> findBy(String name) {
        return em.createQuery("select e from Employee e where e.name = :n", Employee.class)
                .setParameter("n", name)
                .getResultList();
    }

    private void consumeTransaction(Consumer<Employee> anEntityManagerAction, Employee victim) {
        performTransaction(x -> { anEntityManagerAction.accept(x); return x; }, victim);
    }

    private Employee performTransaction(Function<Employee, Employee> anEntityManagerAction, Employee victim) {
        EntityTransaction transaction = em.getTransaction();
        Employee result = null;

        try {
            transaction.begin();
            result = anEntityManagerAction.apply(victim);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            log.error(ex.getMessage(), ex);
        }

        return result;
    }
}
