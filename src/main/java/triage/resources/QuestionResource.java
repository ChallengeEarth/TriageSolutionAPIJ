package triage.resources;

import io.swagger.annotations.Api;
import triage.models.Question;
import triage.services.QuestionService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("/questions")
@Api(value = "Question/Answer Resource")
public class QuestionResource {

    @Inject
    QuestionService questionService;

    @Path("first")
    @GET
    @Produces("application/json")
    public Question getFirstQuestion() {
        return questionService.findById(1);
    }
}
