package com.infosupport.domain;

import jakarta.json.bind.annotation.JsonbSubtype;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.json.bind.annotation.JsonbTypeInfo;
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
@JsonbTypeInfo(key = "@answer", value = {
        @JsonbSubtype(alias = "yesno", type = YesNoAnswer.class),
        @JsonbSubtype(alias = "multi", type = MultiChoiceAnswer.class),
})
public abstract class Answer extends JPAEntity {

    private String text;
    private boolean correct;

    @ManyToOne @JsonbTransient @ToString.Exclude
    private Question question;
}
