package kg.webproject.quiz.io.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity(name="questions")
public class QuestionEntity implements Serializable {     //for persisting an object from memory to a sequence of bits
    private static final long serialVersionUID = -4664052149941848167L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String questionContent;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<AnswerEntity> answers;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonBackReference
    private Quiz quiz;

    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }

    @Column(length = 4000)
    private String explanation;

    public String getExplanation() { return explanation; }
    public void setExplanation(String explanation) { this.explanation = explanation; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Set<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerEntity> answers) {
        this.answers = answers;
    }
}
