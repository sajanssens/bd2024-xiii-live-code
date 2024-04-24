package com.infosupport.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Medewerker")
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e"),
        @NamedQuery(name = "Employee.findByName", query = "select e from Employee e where e.name = :n")
})
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private LocalDate birthdate;

    @Basic(optional = false)
    private int shoeSize = 42;

    public Employee() { }

    public Employee(String name, LocalDate birthdate, int shoeSize) {
        this.name = name;
        this.birthdate = birthdate;
        this.shoeSize = shoeSize;
    }

    public String getName() {
        return name;
    }
}
