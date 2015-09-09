package triage.seed;

import triage.models.Answer;
import triage.models.Patient;
import triage.models.Question;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionAnswerSeed {

    @PersistenceContext
    private EntityManager em;

    public void InsertSeedQuestionAnswers() {

        List<Question> allQuestions = CreateQuestionGraph();

        for (Question question : allQuestions) {
            em.persist(question);
        }
    }

    public static List<Question> CreateQuestionGraph() {
        List<Question> allQuestions = new ArrayList<Question>();

        Question d1 = new Question("Haben Sie Schmerzen beim Wasser lassen / Urinieren?");
        allQuestions.add(d1);

        Question s1 = new Question("Wo ist der Schmerz? (Anmerkung U.Brunner: Test-Antworten, noch nicht abhängig von Hauptbeschwerde)");
        allQuestions.add(s1);

        Question s2 = new Question("Wie fühlt sich der Schmerz an?");
        allQuestions.add(s2);

        Question d2 = new Question("Haben Sie Schmerzen in der Blasen und/oder Nierengegend?");
        allQuestions.add(d2);

        Answer d1a1 = new Answer("Ja",d1,s1);

        Answer d1a2 = new Answer("Nein",d1,d2);

        d1.getAnswers().add(d1a1);
        d1.getAnswers().add(d1a2);

        Answer s1a1 = new Answer("Brust",s1,s2);

        Answer s1a2 = new Answer("Bauch",s1,s2);

        Answer s1a3 = new Answer("Gesäss",s1,s2);

        s1.getAnswers().add(s1a1);
        s1.getAnswers().add(s1a2);
        s1.getAnswers().add(s1a3);
        return allQuestions;
    }
}
