package com.infosupport.resources;

import com.infosupport.domain.ImportDto;
import com.infosupport.repos.ImportRepo;
import com.infosupport.util.filter.NotAuthorized;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("imports")
public class ImportsResource {

    @Inject private ImportRepo repo;

    @POST @Produces(APPLICATION_JSON)
    @NotAuthorized // TODO remove
    public Response start(ImportDto dto) {
        repo.start(dto);
        return Response.ok("Import is started. Check the progress in ...").build();
    }
}
