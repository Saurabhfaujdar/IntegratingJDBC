package org.example;

import org.example.Model.ProblemModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubResourceClass {

    @GET
    public ProblemModel testFunction() {
        System.out.println("hello from subresource");
        return null;
    }
}
