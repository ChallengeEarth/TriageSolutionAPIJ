package triage.resources;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import triage.models.Patient;
import triage.models.Question;
import triage.seed.QuestionAnswerSeed;

import javax.ws.rs.core.HttpHeaders;
import java.util.Date;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.is;

/**
 * Created by ursinbrunner on 11/08/15.
 */
public class QuestionResourceIT {
    @Test
    public void GetFirstQuestion(){
        //Arrange
        Question expectedFirstQuestion = QuestionAnswerSeed.CreateQuestionGraph().get(0);

        //Act
        Response response =
                given()
                        .accept(ContentType.JSON)
                        .expect()
                        .statusCode(javax.ws.rs.core.Response.Status.OK.getStatusCode())
                        .when()
                        .get(TriageUriBuilder.buildUri("questions","first"));

        Question firstQuestion = response.as(Question.class);

        //Assert
        assertThat(firstQuestion,is(expectedFirstQuestion));
    }

    @Test
    public void CreateAndGetNewQuestion(){
        //Arrange
        Question newQuestion = new Question();
        newQuestion.setQuestionMessage("Haben Sie Schmerzen im rechten Bein?");

        //Act
        Response responseCreated =
                given()
                    .body(newQuestion)
                .expect()
                    .statusCode(javax.ws.rs.core.Response.Status.CREATED.getStatusCode())
                .when()
                    .post(TriageUriBuilder.buildUri("questions"));


        String locationCreatedQuestion = responseCreated.getHeader(HttpHeaders.LOCATION);

        //Assert
        Response responseAssert =
                given()
                    .accept(ContentType.JSON)
                .expect()
                    .statusCode(javax.ws.rs.core.Response.Status.OK.getStatusCode())
                .when()
                    .post(locationCreatedQuestion);

        Question questionToVerify = responseAssert.as(Question.class);

        assertThat(questionToVerify.getId(), is(greaterThan(0l)));
        assertThat(questionToVerify.getQuestionMessage(),is(newQuestion.getQuestionMessage()));
    }



}
