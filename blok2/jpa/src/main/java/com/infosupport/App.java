package com.infosupport;

import com.infosupport.domain.Department;
import com.infosupport.domain.Employee;
import com.infosupport.domain.EmployeeDao;
import com.infosupport.domain.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static java.time.LocalDate.of;

public class App {

    private static final EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private static final EntityManager em;

    static {
        em = mySQL.createEntityManager();
    }

    public static void main(String[] args) {
        var employeeDao = new EmployeeDao(em);

        var bram = Employee.builder().name("Bram").birthdate(of(1979, 8, 22)).shoeSize(43).build();
        var dell = Laptop.builder().brand("Dell").build();
        bram.addLaptop(dell); // this method should also set the backward reference!
        employeeDao.create(bram);

        var hp = Laptop.builder().brand("Dell").employee(bram).build();
        bram.addLaptop(hp); // this method should also set the backward reference!
        employeeDao.update(bram);

        var iv = Department.builder().name("InformatieVerwerking").build();
        bram.addDepartment(iv); // this method should also set the backward reference!
        employeeDao.update(bram);
    }
}
