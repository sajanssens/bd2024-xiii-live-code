package com.infosupport.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

// http(s)://localhost:9080/baseball-quiz/api/helloworld
@Path("helloworld")
public class HelloWorldResource {

    @GET
    public Response hello() {
        return Response.ok("Hello World!").build();
    }
}
