package com.infosupport.resources;

import com.infosupport.domain.Answer;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;

import java.util.ArrayList;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Dependent
public class QuestionAnswersResource {

    @GET @Produces(APPLICATION_JSON)
    public List<Answer> getAll() {
        return new ArrayList<>(
                List.of(
                        Answer.builder().text("Klopt").correct(true).build(),
                        Answer.builder().text("Klopt niet").correct(false).build()
                )
        );
    }
}
