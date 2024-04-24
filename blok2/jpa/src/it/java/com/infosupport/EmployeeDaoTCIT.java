package com.infosupport;

import com.infosupport.domain.Employee;
import com.infosupport.domain.EmployeeDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeDaoTCIT {

    private static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:latest");
    private static final EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    private static final EmployeeDao dao = new EmployeeDao(em);

    @BeforeAll
    static void beforeAll() {
        mySQLContainer.start();
    }

    @AfterAll
    static void afterAll() {
        dao.deleteAll();
        mySQLContainer.stop();
        mySQLContainer.close();
    }

    @Test
    void findByName_on_created_employee_returns_that_employee() {
        dao.create(new Employee("Baby", LocalDate.now(), 20));
        List<Employee> emps = dao.findBy("Baby");

        assertThat(emps.size()).isEqualTo(1);
        assertThat(emps.getFirst().getName()).isEqualTo("Baby");
    }
}
