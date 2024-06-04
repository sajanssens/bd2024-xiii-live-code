package com.infosupport.resources;

import com.infosupport.domain.Question;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

// http(s)://localhost:9080/baseball-quiz/api/questions
@Path("questions")
public class QuestionsResource {

    private static List<Question> questions = List.of(
            Question.builder().id(1).question("test").build(),
            Question.builder().id(2).question("test2").build()
    );

    @GET @Produces(APPLICATION_JSON)
    public List<Question> getList(@QueryParam("question") String question) {
        if (question == null || question.isBlank()) {
            return questions;
        }

        return questions.stream().filter(q -> question.contains(q.getQuestion())).toList();
    }

    @POST
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public Question add(Question q) {
        // zet q in de database
        q.setId(42);
        return q;
    }

    @Path("{id}")
    public QuestionResource getQuestionsResource(@PathParam("id") int id) {
        return new QuestionResource(id);
    }
}
