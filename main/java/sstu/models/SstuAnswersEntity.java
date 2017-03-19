package sstu.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Доктор кто on 19.03.2017.
 */
@Entity
@Table(name = "sstu_answers")
public class SstuAnswersEntity {
    private Long idSstuAnswers;
    private String sstuAnswer;
    private byte[] sstuCorrect;
    private SstuQuestionsEntity sstuQuestionsBySstuIdQuestion;
    private Collection<SstuResultsEntity> sstuResultsesByIdSstuAnswers;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sstu_answers", nullable = false)
    public Long getIdSstuAnswers() {
        return idSstuAnswers;
    }

    public void setIdSstuAnswers(Long idSstuAnswers) {
        this.idSstuAnswers = idSstuAnswers;
    }

    @Basic
    @Column(name = "sstu_answer", nullable = false, length = -1)
    public String getSstuAnswer() {
        return sstuAnswer;
    }

    public void setSstuAnswer(String sstuAnswer) {
        this.sstuAnswer = sstuAnswer;
    }

    @Basic
    @Column(name = "sstu_correct", nullable = false)
    public byte[] getSstuCorrect() {
        return sstuCorrect;
    }

    public void setSstuCorrect(byte[] sstuCorrect) {
        this.sstuCorrect = sstuCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SstuAnswersEntity that = (SstuAnswersEntity) o;

        if (idSstuAnswers != that.idSstuAnswers) return false;
        if (sstuAnswer != null ? !sstuAnswer.equals(that.sstuAnswer) : that.sstuAnswer != null) return false;
        if (!Arrays.equals(sstuCorrect, that.sstuCorrect)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idSstuAnswers;
        result = 31 * result + (sstuAnswer != null ? sstuAnswer.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(sstuCorrect);
        return (int)result.longValue();
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_question", referencedColumnName = "id_sstu_question", nullable = false)
    public SstuQuestionsEntity getSstuQuestionsBySstuIdQuestion() {
        return sstuQuestionsBySstuIdQuestion;
    }

    public void setSstuQuestionsBySstuIdQuestion(SstuQuestionsEntity sstuQuestionsBySstuIdQuestion) {
        this.sstuQuestionsBySstuIdQuestion = sstuQuestionsBySstuIdQuestion;
    }

    @OneToMany(mappedBy = "sstuAnswersBySstuIdAnswer")
    public Collection<SstuResultsEntity> getSstuResultsesByIdSstuAnswers() {
        return sstuResultsesByIdSstuAnswers;
    }

    public void setSstuResultsesByIdSstuAnswers(Collection<SstuResultsEntity> sstuResultsesByIdSstuAnswers) {
        this.sstuResultsesByIdSstuAnswers = sstuResultsesByIdSstuAnswers;
    }
}
