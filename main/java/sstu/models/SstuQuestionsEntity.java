package sstu.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Доктор кто on 19.03.2017.
 */
@Entity
@Table(name = "sstu_questions")
public class SstuQuestionsEntity {
    private Long idSstuQuestion;
    private String sstuQuestion;
    private int sstuMaxAnswers;
    private Collection<SstuAnswersEntity> sstuAnswersesByIdSstuQuestion;
    private SstuQuestionTypesEntity sstuQuestionTypesBySstuIdQuestionType;
    private SstuWorksheetsEntity sstuWorksheetsBySstuIdWorksheet;
    private Collection<SstuResultsEntity> sstuResultsesByIdSstuQuestion;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sstu_question", nullable = false)
    public Long getIdSstuQuestion() {
        return idSstuQuestion;
    }

    public void setIdSstuQuestion(Long idSstuQuestion) {
        this.idSstuQuestion = idSstuQuestion;
    }

    @Basic
    @Column(name = "sstu_question", nullable = false, length = -1)
    public String getSstuQuestion() {
        return sstuQuestion;
    }

    public void setSstuQuestion(String sstuQuestion) {
        this.sstuQuestion = sstuQuestion;
    }

    @Basic
    @Column(name = "sstu_max_answers", nullable = false)
    public int getSstuMaxAnswers() {
        return sstuMaxAnswers;
    }

    public void setSstuMaxAnswers(int sstuMaxAnswers) {
        this.sstuMaxAnswers = sstuMaxAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SstuQuestionsEntity that = (SstuQuestionsEntity) o;

        if (idSstuQuestion != that.idSstuQuestion) return false;
        if (sstuMaxAnswers != that.sstuMaxAnswers) return false;
        if (sstuQuestion != null ? !sstuQuestion.equals(that.sstuQuestion) : that.sstuQuestion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idSstuQuestion;
        result = 31 * result + (sstuQuestion != null ? sstuQuestion.hashCode() : 0);
        result = 31 * result + sstuMaxAnswers;
        return (int)result.longValue();
    }

    @OneToMany(mappedBy = "sstuQuestionsBySstuIdQuestion")
    public Collection<SstuAnswersEntity> getSstuAnswersesByIdSstuQuestion() {
        return sstuAnswersesByIdSstuQuestion;
    }

    public void setSstuAnswersesByIdSstuQuestion(Collection<SstuAnswersEntity> sstuAnswersesByIdSstuQuestion) {
        this.sstuAnswersesByIdSstuQuestion = sstuAnswersesByIdSstuQuestion;
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_question_type", referencedColumnName = "id_sstu_question_type", nullable = false)
    public SstuQuestionTypesEntity getSstuQuestionTypesBySstuIdQuestionType() {
        return sstuQuestionTypesBySstuIdQuestionType;
    }

    public void setSstuQuestionTypesBySstuIdQuestionType(SstuQuestionTypesEntity sstuQuestionTypesBySstuIdQuestionType) {
        this.sstuQuestionTypesBySstuIdQuestionType = sstuQuestionTypesBySstuIdQuestionType;
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_worksheet", referencedColumnName = "id_sstu_worksheet")
    public SstuWorksheetsEntity getSstuWorksheetsBySstuIdWorksheet() {
        return sstuWorksheetsBySstuIdWorksheet;
    }

    public void setSstuWorksheetsBySstuIdWorksheet(SstuWorksheetsEntity sstuWorksheetsBySstuIdWorksheet) {
        this.sstuWorksheetsBySstuIdWorksheet = sstuWorksheetsBySstuIdWorksheet;
    }

    @OneToMany(mappedBy = "sstuQuestionsBySstuIdQuestion")
    public Collection<SstuResultsEntity> getSstuResultsesByIdSstuQuestion() {
        return sstuResultsesByIdSstuQuestion;
    }

    public void setSstuResultsesByIdSstuQuestion(Collection<SstuResultsEntity> sstuResultsesByIdSstuQuestion) {
        this.sstuResultsesByIdSstuQuestion = sstuResultsesByIdSstuQuestion;
    }
}
