package com.infosupport.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Builder @AllArgsConstructor
@Entity
@IdClass(CompositeKey.class)
public class FormulierObject {

    @Id
    int id;

    @Id @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vragenlijstId")
    Vragenlijst vragenlijst;

    @ManyToOne
    @JoinColumn(name = "terug_id", referencedColumnName = "id")
    @JoinColumn(name = "terug_vragenlijst_id", referencedColumnName = "vragenlijstId")
    FormulierObject foOudertje;
}

