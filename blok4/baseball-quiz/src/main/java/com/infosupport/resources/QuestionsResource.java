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
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

// .../baseball-quiz/api/questions
@Path("questions")
@OpenAPIDefinition(info = @Info(title = "QuestionsResource", description = "Some cool info...", version = "1"))
public class QuestionsResource {

    // Zie hier voor alle mogelijkheden om je endpoints extra te documenteren:
    // https://download.eclipse.org/microprofile/microprofile-open-api-1.0/microprofile-openapi-spec.html#_documentation_mechanisms

    @Inject
    private QuestionRepo repo;

    @Inject
    private QuestionResource questionResource;

    @Operation(description = "Returns all questions when no query string is included.")
    @GET @Produces(APPLICATION_JSON)
    public List<Question> getList(
            @Parameter(description = "to search on question text (containing)")
            @QueryParam("question") String question) {
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
    public QuestionResource getQuestionsResource(@PathParam("id") int i) {
        return questionResource.withId(i);
    }
}
