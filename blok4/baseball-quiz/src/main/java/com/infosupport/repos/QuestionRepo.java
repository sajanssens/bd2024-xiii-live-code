package com.infosupport.repos;

import com.infosupport.domain.Question;
import jakarta.enterprise.context.Dependent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Dependent // since bean-discovery-mode="annotated"
public class QuestionRepo {

    private final AtomicInteger lastId = new AtomicInteger(1);

    private final List<Question> questions = new ArrayList<>(List.of(
            Question.builder().id(nextId()).text("test1").build(),
            Question.builder().id(nextId()).text("test2").build(),
            Question.builder().id(nextId()).text("test3").build(),
            Question.builder().id(nextId()).text("test4").build(),
            Question.builder().id(nextId()).text("test5").build(),
            Question.builder().id(nextId()).text("test6").build()
    ));

    public Question create(Question q) {
        q.setId(nextId());
        questions.add(q);
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
        this.questions.removeIf(q -> q.getId() == id);
    }

    private int nextId() {
        return lastId.getAndIncrement();
    }
}
