package org.example;

import org.example.Model.ProblemModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("secured")
public class SecuredResource {
    @GET
    @Path("problems")
    @Produces(MediaType.TEXT_PLAIN)
    public String securedAPI() {
    return "hsdhs\n";
    }
}

