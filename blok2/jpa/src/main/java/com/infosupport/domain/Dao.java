package com.infosupport.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public abstract class Dao {

    protected final EntityManager em;

    public Dao(EntityManager em) { this.em = em; }

    public <T> void consumeTransaction(Runnable anEntityManagerAction) {
        performTransaction((T x) -> { anEntityManagerAction.run(); return x; }, null);
    }

    public <T> void consumeTransaction(Consumer<T> anEntityManagerAction, T victim) {
        performTransaction(x -> { anEntityManagerAction.accept(x); return x; }, victim);
    }

    public <T> T performTransaction(Function<T, T> anEntityManagerAction, T victim) {
        T result = null;

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            result = anEntityManagerAction.apply(victim);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            log.error("Something bad happened. Rolling back... " + ex.getMessage(), ex);
        }

        return result;
    }
}
