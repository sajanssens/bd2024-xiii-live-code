package com.infosupport;

import com.infosupport.domain.FormulierObject;
import com.infosupport.domain.Vragenlijst;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;

import java.util.function.Consumer;
import java.util.function.Function;

class FormulierObjectIT {

    private static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:latest");
    private static final EntityManager em = Persistence.createEntityManagerFactory("MySQL-test").createEntityManager();

    @BeforeAll
    static void beforeAll() {
        mySQLContainer.start();
    }

    @AfterAll
    static void afterAll() {
        mySQLContainer.stop();
        mySQLContainer.close();
    }

    @AfterEach
    public void teardown() {
        // If some tests have open transactions because of exceptions
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    @Test
    void test() {
        Vragenlijst v1 = Vragenlijst.builder().name("v1").build();
        Vragenlijst v2 = Vragenlijst.builder().name("v2").build();
        v1 = execute(em::merge, v1);
        v2 = execute(em::merge, v2);

        FormulierObject o0 = FormulierObject.builder().id(1).vragenlijst(v1).build();
        FormulierObject o1 = FormulierObject.builder().id(1).vragenlijst(v2).foOudertje(o0).build();
        execute(em::merge, o0);
        execute(em::merge, o1);
    }

    public <T> T execute(Function<T, T> anEntityManagerAction, T victim) {
        T result = null;

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            result = anEntityManagerAction.apply(victim);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        }

        return result;
    }

    public <T> void execute2(Consumer<T> anEntityManagerAction, T victim) {
        execute(x -> { anEntityManagerAction.accept(x); return x; }, victim);
    }
}
