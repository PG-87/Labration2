package se.alten.java19project.rest;

import lombok.NoArgsConstructor;
import se.alten.java19project.dao.JavaAccessLocal;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@NoArgsConstructor
@Path("/name")

public class JavaController {

    @Inject
    private JavaAccessLocal javaAccessLocal;

    @GET
    @Produces("application/JSON")
    public Response showNames(){
        try{
            System.out.println("IN CONTROLLER!!!!!!!");
            List names = javaAccessLocal.getAllNames();
            return Response.ok(names).build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}