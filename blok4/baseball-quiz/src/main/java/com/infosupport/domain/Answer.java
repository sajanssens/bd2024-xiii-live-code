package com.infosupport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@XmlRootElement
@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
@Entity
public class Answer {

    @Id @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String text;
    private boolean isCorrect;

    @ManyToOne
    private Question question;
}
