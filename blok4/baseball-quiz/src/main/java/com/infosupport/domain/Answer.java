package com.infosupport.domain;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@XmlRootElement
@SuperBuilder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = true)
@Entity
public class Answer extends JPAEntity {

    private String text;
    private boolean correct;

    @ManyToOne @JsonbTransient
    private Question question;
}
