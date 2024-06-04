package com.infosupport.resources;

import com.infosupport.domain.Question;
import com.infosupport.repos.QuestionRepo;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import lombok.NoArgsConstructor;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

// .../baseball-quiz/api/questions/{id}
@NoArgsConstructor
@Dependent // since bean-discovery-mode="annotated"
public class QuestionResource {

    @Inject
    private QuestionRepo repo;
    private int id;

    @GET @Produces(APPLICATION_JSON)
    public Question get() {
        return repo.read(id).orElseThrow(BadRequestException::new);
    }

    @DELETE
    public void del() {
        repo.delete(id);
    }

    @PUT
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public Question edit(Question q) {
        get().setText(q.getText());
        return q;
    }

    public QuestionResource with(int id) {
        this.id = id;
        return this;
    }
}

