package controllers;

import models.User;
import services.UserService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/users")
public class UserController {

    @Inject
    private UserService userService;

    @GET
    @Produces("application/json")
    public JsonArray getAllUsers() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (User user : userService.getAll()) {
            builder.add(Json.createObjectBuilder().add("email",user.getEmail()));
        }
        return builder.build();
    }
}
