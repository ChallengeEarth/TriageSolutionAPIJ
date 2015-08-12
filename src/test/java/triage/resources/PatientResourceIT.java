package triage.resources;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import triage.models.Patient;
import triage.seed.PatientSeed;

import java.util.Date;
import java.util.UUID;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by ursinbrunner on 10/08/15.
 */
public class PatientResourceIT {

    @Test
    public void GetDefaultPatient(){
        //Arrange
        Patient expectedPatient = PatientSeed.CreateDefaultPatient();

        //Act
        Response response =
                given()
                        .accept(ContentType.JSON)
                .expect()
                        .statusCode(javax.ws.rs.core.Response.Status.OK.getStatusCode())
                .when()
                        .get(TriageUriBuilder.buildUri("patients"));

        Patient[] patients = response.as(Patient[].class);

        //Assert
        assertThat(patients,hasItemInArray(expectedPatient));
    }
}
