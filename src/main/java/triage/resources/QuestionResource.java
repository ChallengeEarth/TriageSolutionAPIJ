package triage.resources;

import io.swagger.annotations.Api;
import triage.models.Question;
import triage.services.QuestionService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

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
        Question q = questionService.findFirstElement();
        return q;
    }

    @Path("{questionId}")
    @GET
    @Produces("application/json")
    public Question getQuestionById(@PathParam("questionId")int questionId) {
        return questionService.findById(questionId);
    }

    @POST
    @Consumes("application/json")
    public Response createQuestion(Question newQuestion,@Context UriInfo uriInfo) {
        questionService.saveQuestion(newQuestion);

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Long.toString(newQuestion.getId()));

        return Response.created(uriBuilder.build()).build();
    }
}
