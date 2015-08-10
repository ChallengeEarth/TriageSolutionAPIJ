package triage.services;

import triage.models.Patient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PatientService {

    @PersistenceContext
    private EntityManager em;

    public List<Patient> getAll() {
        TypedQuery<Patient> query = em.createQuery("select p from Patient p", Patient.class);
        return query.getResultList();
    }
}
