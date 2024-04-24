package com.infosupport.domain;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public class Dao {

    public static <T> void consumeTransaction(EntityManager em, Consumer<T> anEntityManagerAction, T victim) {
        performTransaction(em, x -> { anEntityManagerAction.accept(x); return x; }, victim);
    }

    public static  <T> T performTransaction(EntityManager em, Function<T, T> anEntityManagerAction, T victim) {
        T result = null;

        try {
            em.getTransaction().begin();
            result = anEntityManagerAction.apply(victim);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            log.error(ex.getMessage(), ex);
        }

        return result;
    }
}
