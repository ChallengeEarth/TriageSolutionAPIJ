package triage.services;

import triage.models.Language;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class LanguageService {
    @PersistenceContext
    private EntityManager em;

    public List<Language> getAll() {
        TypedQuery<Language> query = em.createQuery("select l from Language l", Language.class);
        return query.getResultList();
    }
}
