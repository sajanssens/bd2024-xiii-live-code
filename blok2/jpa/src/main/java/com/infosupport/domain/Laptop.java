package com.infosupport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder @AllArgsConstructor
@NoArgsConstructor
public class Laptop {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brand;

    @ManyToOne
    private Employee employee;

}
