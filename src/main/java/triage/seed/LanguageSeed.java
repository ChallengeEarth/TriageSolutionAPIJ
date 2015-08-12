package triage.seed;

import triage.models.Language;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ursinbrunner on 10/08/15.
 */
public class LanguageSeed {

    @PersistenceContext
    private EntityManager em;

    public void InsertSeedLanguages() {

        Language german = CreateGermanLanguage();
        Language french = CreateFrenchLanguage();

        em.persist(german);
        em.persist(french);
    }

    public static Language CreateFrenchLanguage() {
        return new Language("fr","Bonjour","http://localhost:8080/triage-app/images/language_flags/fr.png");
    }

    public static Language CreateGermanLanguage() {
        return new Language("de","Guten Tag","http://localhost:8080/triage-app/images/language_flags/de.png");
    }

}
