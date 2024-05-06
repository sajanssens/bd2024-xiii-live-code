package com.infosupport;

import com.infosupport.domain.Employee;
import com.infosupport.domain.EmployeeDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeDaoIT {

    private static final EntityManager em = Persistence.createEntityManagerFactory("H2").createEntityManager();

    private EmployeeDao dao = new EmployeeDao(em);

    @AfterEach
    public void teardown() {
        // If some tests have open transactions because of exceptions
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    @Test
    void findByName_on_created_employee_returns_that_employee() {
        dao.create(new Employee("Baby", LocalDate.now(), 20));
        List<Employee> emps = dao.findBy("Baby");

        assertThat(emps.size()).isEqualTo(1);
        assertThat(emps.getFirst().getName()).isEqualTo("Baby");
    }

    @Test
    void createOnInvalidEmployeeThrowsValidationException() {
        assertThrows(ConstraintViolationException.class, () -> dao.create(new Employee("Baby", LocalDate.now(), 9)));
        assertThrows(ConstraintViolationException.class, () -> dao.create(new Employee("Baby", LocalDate.now().plusDays(1), 9)));
    }
}
