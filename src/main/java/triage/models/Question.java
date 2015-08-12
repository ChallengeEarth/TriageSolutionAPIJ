package triage.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Question {
    @Id
    private int id;
    private String questionMessage;

    @OneToMany(mappedBy="parentQuestion",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Answer> answers;

    public Question() {
    }

    public Question(int id, String questionMessage) {
        this.id = id;
        this.questionMessage = questionMessage;

        this.answers = new ArrayList<Answer>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionMessage() {
        return questionMessage;
    }

    public void setQuestionMessage(String questionMessage) {
        this.questionMessage = questionMessage;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (getId() != question.getId()) return false;
        if (getQuestionMessage() != null ? !getQuestionMessage().equals(question.getQuestionMessage()) : question.getQuestionMessage() != null)
            return false;
        return !(getAnswers() != null ? !getAnswers().equals(question.getAnswers()) : question.getAnswers() != null);

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getQuestionMessage() != null ? getQuestionMessage().hashCode() : 0);
        result = 31 * result + (getAnswers() != null ? getAnswers().hashCode() : 0);
        return result;
    }
}
