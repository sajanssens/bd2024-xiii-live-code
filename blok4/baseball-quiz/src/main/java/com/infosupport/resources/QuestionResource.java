package com.infosupport.resources;

import com.infosupport.domain.Question;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

public class QuestionResource {

    private static List<Question> questions = List.of(
            Question.builder().id(1).question("test").build(),
            Question.builder().id(2).question("test2").build()
    );

    private final int id;

    public QuestionResource(int id) {
        this.id = id;
    }

    @GET
    public Question get() {
        return questions.stream()
                .filter(q -> q.getId() == id)
                .findAny()
                .orElseThrow(BadRequestException::new);
    }

    @DELETE
    public Question del() {
        return questions.stream()
                .filter(q -> q.getId() == id)
                .findAny()
                .orElseThrow(BadRequestException::new);
    }

    @PUT
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public Question edit(Question q) {
        // wijzig q in de database
        q.setQuestion("Iets anders");
        return q;
    }
}

