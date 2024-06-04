package com.infosupport.resources;

import com.infosupport.domain.Question;
import com.infosupport.repos.QuestionRepo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

// .../baseball-quiz/api/questions
@Path("questions")
public class QuestionsResource {

    @Inject
    private QuestionRepo repo;

    @Inject
    private QuestionResource questionResource;

    @GET @Produces(APPLICATION_JSON)
    public List<Question> getList(@QueryParam("question") String question) {
        if (question == null || question.isBlank()) {
            return repo.readAll();
        }

        return repo.readAll().stream()
                .filter(q -> question.contains(q.getText()))
                .toList();
    }

    @POST
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public Question add(Question q) {
        return repo.create(q);
    }

    @Path("{id}")
    public QuestionResource getQuestionsResource(@PathParam("id") int id) {
        return questionResource.with(id);
    }
}
