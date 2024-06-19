package com.infosupport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import java.util.Set;

@XmlRootElement
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = true)
@Entity @NoArgsConstructor
@Builder @AllArgsConstructor
public class Question extends JPAEntity {

    private String text;
    private Integer strikes;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Singular
    public Set<Answer> answers;
}
