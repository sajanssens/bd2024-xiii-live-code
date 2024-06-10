package com.infosupport.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.lastName DESC"),
        @NamedQuery(name = User.FIND_BY_USERNAME_AND_PASSWORD, query = "SELECT u FROM User u WHERE u.username = :login AND u.password = :password")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@SuperBuilder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = true)
@Table(name = "User")
public class User extends JPAEntity {

    public static final String FIND_BY_USERNAME_AND_PASSWORD = "User.findByUsernameAndPassword";

    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 256, nullable = false)
    private String password;

    @Transient // don't store in db
    private String token;
}
