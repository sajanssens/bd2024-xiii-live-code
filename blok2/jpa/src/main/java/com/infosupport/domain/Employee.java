package com.infosupport.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Data @Builder @AllArgsConstructor
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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "employee", fetch = LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Laptop> laptops = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @ManyToMany(mappedBy = "employees", fetch = LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Department> worksAt = new HashSet<>();

    public Employee() { }

    public Employee(String name, LocalDate birthdate, int shoeSize) {
        this.name = name;
        this.birthdate = birthdate;
        this.shoeSize = shoeSize;
    }

    public void addLaptop(Laptop laptop) {
        this.laptops.add(laptop);
        laptop.setEmployee(this);
    }

    public void addDepartment(Department department) {
        this.worksAt.add(department);
        department.getEmployees().add(this);
    }
}
