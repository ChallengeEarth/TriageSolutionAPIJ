package triage.resources;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import javax.ws.rs.core.Response.Status;
import org.junit.Test;
import triage.models.Language;
import triage.seed.LanguageSeed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class LanguageResourceIT {

    @Test
    public void GermanLanguageAvailable() {

        //Arrange
        Language expectedGermanLanguage = LanguageSeed.CreateGermanLanguage();

        //Act
        Response response =
                given()
                        .accept(ContentType.JSON)
                .expect()
                        .statusCode(Status.OK.getStatusCode())
                .when()
                        .get(TriageUriBuilder.buildUri("languages"));

        Language[] languages = response.as(Language[].class);

        //Assert
        assertThat(languages,hasItemInArray(expectedGermanLanguage));
    }

}
