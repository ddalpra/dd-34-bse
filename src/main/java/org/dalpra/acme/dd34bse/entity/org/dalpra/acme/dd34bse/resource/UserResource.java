package org.dalpra.acme.dd34bse.entity.org.dalpra.acme.dd34bse.resource;

import org.dalpra.acme.dd34bse.entity.User;
import org.dalpra.acme.dd34bse.entity.org.dalpra.acme.dd34bse.repository.UserRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/users")
public class UserResource {

    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<User> users = userRepository.listAll();
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        return userRepository.findByIdOptional(id).
                map(user -> Response.ok(user).build())
                .orElse(Response.status(404).build());
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        userRepository.persist(user);
        if (userRepository.isPersistent(user)) {
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id) {
        boolean deleted = userRepository.deleteById(id);
        return deleted ? Response.noContent().
                build() : Response.status(404).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, User user) {
        User obj = userRepository.findById(id);
        obj.setEmailId(user.getEmailId());
        obj.setFirstName(user.getFirstName());
        obj.setLastName(user.getLastName());
        return Response.status(200).build();

    }
}
