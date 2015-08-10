package triage.resources;

import io.swagger.annotations.Api;
import triage.models.Patient;
import triage.services.PatientService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
@Path("/patients")
@Api(value = "Patient Resource")
public class PatientResource {

    @Inject
    PatientService patientService;

    @GET
    @Produces("application/json")
    public List<Patient> GetAllPatients() {
        return patientService.getAll();
    }
}
