package com.infosupport;

import com.infosupport.domain.Employee;
import com.infosupport.domain.EmployeeDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {

    private static final EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private static final EntityManager em;

    static {
        em = mySQL.createEntityManager();
    }

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao(em);

        Employee bram = new Employee("Bram", LocalDate.of(1979, 8, 22), 43);
        employeeDao.save(bram);

        em.close();
        mySQL.close();
    }
}
