package com.infosupport.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
public abstract class JPAEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Version // voor optimistic locking
    protected long version;

    @Transient
    protected String _self;
}
