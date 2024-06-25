package com.infosupport.domain;

import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@XmlRootElement
@SuperBuilder @NoArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = true)
@Entity
public class YesNoAnswer extends Answer {
}
