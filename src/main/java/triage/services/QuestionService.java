package triage.services;


import triage.models.Language;
import triage.models.Patient;
import triage.models.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class QuestionService {

    @PersistenceContext
    private EntityManager em;

    public Question findById(int questionId) {
        Question firstQuestion = em.find(Question.class, questionId);
        return firstQuestion;
    }

    public void saveQuestion(Question question) {
        em.persist(question);
    }

    public Question findFirstElement() {
        TypedQuery<Question> query = em.createNamedQuery("Question.root",Question.class);
        return query.getSingleResult();
    }
}
