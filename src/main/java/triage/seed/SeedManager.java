package triage.seed;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class SeedManager {

    @Inject
    LanguageSeed languageSeed;

    @Inject
    PatientSeed patientSeed;

    @Inject
    QuestionAnswerSeed questionAnswerSeed;

    @PostConstruct
    public void initializeSeed() {
        languageSeed.InsertSeedLanguages();
        patientSeed.InsertSeedPatients();
        questionAnswerSeed.InsertSeedQuestionAnswers();
    }
}
