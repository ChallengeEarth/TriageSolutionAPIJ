package triage.seed;

import triage.models.Language;
import triage.models.Patient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.UUID;

public class PatientSeed {

    @PersistenceContext
    private EntityManager em;

    public void InsertSeedPatients() {
        Patient patient = CreateDefaultPatient();

        em.persist(patient);
    }

    public static Patient CreateDefaultPatient() {
        return new Patient(12, "John Doe", 45, "Schmerzen in der Brust", new Date());
    }
}
