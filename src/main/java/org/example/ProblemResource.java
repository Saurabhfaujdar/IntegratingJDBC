package org.example;

import org.example.Model.ProblemModel;
import org.example.Service.ProblemService;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/problems")
public class ProblemResource {

    final static ProblemService problemService = new ProblemService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProblemModel> getProblems() throws ClassNotFoundException, SQLException {
        return problemService.fetchProblems();
    }

    //Function to demonstrate how to access query params and customHeader parameters and cookies
    @Path("/demo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProblemModel> accessQueryParams(@QueryParam("year") int year,
                                                @QueryParam("month") int month,
                                                @QueryParam("day") int day,
                                                @HeaderParam("customHeaderParam") String header,
                                                @CookieParam("name") String value) {
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(header);
        System.out.println(value);
        return null;
    }
    //Function to demonstrate how to access headers using context
    @Path("/context")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProblemModel> accessParams(@Context UriInfo uriInfo,
                                           @Context HttpHeaders httpHeaders) {
        System.out.println(uriInfo.getAbsolutePath().toString());
        System.out.println(httpHeaders.getCookies().toString());
        return null;
    }

    @GET
    @Path("/{problemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProblemModel getProblem(@PathParam("problemId") long id) throws SQLException, ClassNotFoundException {
        System.out.println(id);
        return problemService.fetchProblem((int)id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProblem(ProblemModel problemModel) throws ClassNotFoundException {

        return Response.status(Response.Status.CREATED)
                .entity(problemModel)
                .build();
    }

    @PUT
    @Path("/{problemId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProblem(@PathParam("problemId") long id, ProblemModel problemModel) throws SQLException, ClassNotFoundException {
        problemModel.setId((int)id);
        problemService.updateProblem((int)id, problemModel);
    }

    @DELETE
    @Path("/{problemId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteProblem(@PathParam("problemId") long id) throws SQLException, ClassNotFoundException {
        problemService.deleteProblem((int)id);
    }

    @GET
    @Path("/subResources")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SubResourceClass getSubResource() {
    return new SubResourceClass();
    }
}

