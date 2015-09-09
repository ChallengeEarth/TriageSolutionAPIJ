package triage.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@NamedQuery(name="Question.root", query="" +
        "select q from Question q " +
        "where not exists (" +
        "select a from Answer a where a.followingQuestion = q)"
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String questionMessage;

    @OneToMany(mappedBy="parentQuestion",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Answer> answers;

    public Question() {
        this.answers = new ArrayList<Answer>();
    }

    public Question(String questionMessage) {
        this();
        this.questionMessage = questionMessage;

    }

    public long getId() {
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
        return !(getQuestionMessage() != null ? !getQuestionMessage().equals(question.getQuestionMessage()) : question.getQuestionMessage() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getQuestionMessage() != null ? getQuestionMessage().hashCode() : 0);
        return result;
    }
}
