package com.infosupport.repos;

import com.infosupport.domain.Question;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped // since bean-discovery-mode="annotated"
public class QuestionRepo {

    @PersistenceContext(name = "MySQL")
    private EntityManager em;

    private final AtomicInteger lastId = new AtomicInteger(1);

    private final List<Question> questions = new ArrayList<>(List.of(
            Question.builder().id(nextId()).text("test1").build(),
            Question.builder().id(nextId()).text("test2").build(),
            Question.builder().id(nextId()).text("test3").build(),
            Question.builder().id(nextId()).text("test4").build(),
            Question.builder().id(nextId()).text("test5").build(),
            Question.builder().id(nextId()).text("test6").build()
    ));

    @Transactional
    public Question create(Question q) {
        em.persist(q);
        return q;
    }

    public Optional<Question> read(int id) {
        return readAll().stream()
                .filter(q -> q.getId() == id)
                .findAny();
    }

    public List<Question> readAll() {
        return questions;
    }

    public void delete(int id) {
        System.out.println("delete " + id);
        System.out.println(this.questions.removeIf(q -> q.getId() == id));
    }

    private int nextId() {
        return lastId.getAndIncrement();
    }
}
