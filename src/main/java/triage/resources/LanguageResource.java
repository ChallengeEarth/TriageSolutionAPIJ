package triage.resources;

import io.swagger.annotations.Api;
import triage.models.Language;
import triage.services.LanguageService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;

@Stateless
@Path("/languages")
@Api(value = "LanguageResource")
public class LanguageResource {

    @Inject
    private LanguageService languageService;

    @GET
    @Produces("application/json")
    public ArrayList<Language> getAllLanguages() {
        return new ArrayList<Language>(languageService.getAll());
    }
}
