package triage.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "answers")
@XmlRootElement
//Only a few attributes are important for the clients, we will annotate them.
@XmlAccessorType(XmlAccessType.NONE)
public class Answer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String answerMessage;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_question_id")
    private Question parentQuestion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "following_question_id")
    private Question followingQuestion;

    public Answer() {
    }

    public Answer(String answerMessage, Question parentQuestion, Question followingQuestion) {
        this.answerMessage = answerMessage;
        this.parentQuestion = parentQuestion;
        this.followingQuestion = followingQuestion;
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }

    @XmlAttribute
    public String getAnswerMessage() {
        return answerMessage;
    }

    @XmlAttribute
    public void setAnswerMessage(String answerMessage) {
        this.answerMessage = answerMessage;
    }

    @XmlAttribute
    public long getFollowingQuestionId() {
        if(followingQuestion != null) {
            return followingQuestion.getId();
        } else {
            return  -1;
        }
    }

    /**
     * this method should actually never be used, but we need it for Deserialization in the Integrationtests.
     * Alternative would be to introduce separate Question/Answer-classes for the tests (but i'm too lazy for that now :-)
     * @param followingQuestionId
     */
    public void setFollowingQuestionId(int followingQuestionId) {
        if (followingQuestion == null) {
            Question dummyQuestion = new Question("I'm a dummy-question!");
            dummyQuestion.setId(followingQuestionId);

            setFollowingQuestion(dummyQuestion);
        } else {
            throw new IllegalStateException("You should not use setFollowingQuestionId() if that's not a test-scenario");
        }
    }



    public Question getFollowingQuestion() {
        return followingQuestion;
    }

    public void setFollowingQuestion(Question followingQuestion) {
        this.followingQuestion = followingQuestion;
    }

    public Question getParentQuestion() {
        return parentQuestion;
    }

    public void setParentQuestion(Question parentQuestion) {
        this.parentQuestion = parentQuestion;
    }


    /**
     * Custom-Implementation at the end (getFollowingQuestionId), don't just regenerate.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (getId() != answer.getId()) return false;
        if (getAnswerMessage() != null ? !getAnswerMessage().equals(answer.getAnswerMessage()) : answer.getAnswerMessage() != null)
            return false;
        return getFollowingQuestionId() == answer.getFollowingQuestionId();

    }

    /**
     * Custom-Implementation at the end (getFollowingQuestionId), don't just regenerate.
     * @return
     */
    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getAnswerMessage() != null ? getAnswerMessage().hashCode() : 0);
        result = 31 * result + (int)getFollowingQuestionId();
        return result;
    }
}
