package rest.services;

import domain.Person;
import domain.service.PeopleService;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("people")
public class PersonResource {

    private PeopleService db = new PeopleService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getData() {
        return db.getData();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person p) {
        if (p.getBirthday()==null){
            p.setBirthday(new Date());
        }
        db.addPerson((p));
        return Response.ok(p.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Person p) {
        p.setId(id);
        db.update(p);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        db.delete(id);
        return Response.ok().build();
    }

}
