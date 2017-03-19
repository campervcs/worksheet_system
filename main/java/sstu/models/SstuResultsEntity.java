package sstu.models;

import javax.persistence.*;

/**
 * Created by Доктор кто on 19.03.2017.
 */
@Entity
@Table(name = "sstu_results")
public class SstuResultsEntity {
    private Long idSstuResult;
    private SstuWorksheetsEntity sstuWorksheetsBySstuIdWorksheet;
    private SstuUsersEntity sstuUsersBySstuIdUser;
    private SstuAnswersEntity sstuAnswersBySstuIdAnswer;
    private SstuQuestionsEntity sstuQuestionsBySstuIdQuestion;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sstu_result", nullable = false)
    public Long getIdSstuResult() {
        return idSstuResult;
    }

    public void setIdSstuResult(Long idSstuResult) {
        this.idSstuResult = idSstuResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SstuResultsEntity that = (SstuResultsEntity) o;

        if (idSstuResult != that.idSstuResult) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)idSstuResult.longValue();
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_worksheet", referencedColumnName = "id_sstu_worksheet", nullable = false)
    public SstuWorksheetsEntity getSstuWorksheetsBySstuIdWorksheet() {
        return sstuWorksheetsBySstuIdWorksheet;
    }

    public void setSstuWorksheetsBySstuIdWorksheet(SstuWorksheetsEntity sstuWorksheetsBySstuIdWorksheet) {
        this.sstuWorksheetsBySstuIdWorksheet = sstuWorksheetsBySstuIdWorksheet;
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_user", referencedColumnName = "id_sstu_user", nullable = false)
    public SstuUsersEntity getSstuUsersBySstuIdUser() {
        return sstuUsersBySstuIdUser;
    }

    public void setSstuUsersBySstuIdUser(SstuUsersEntity sstuUsersBySstuIdUser) {
        this.sstuUsersBySstuIdUser = sstuUsersBySstuIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_answer", referencedColumnName = "id_sstu_answers", nullable = false)
    public SstuAnswersEntity getSstuAnswersBySstuIdAnswer() {
        return sstuAnswersBySstuIdAnswer;
    }

    public void setSstuAnswersBySstuIdAnswer(SstuAnswersEntity sstuAnswersBySstuIdAnswer) {
        this.sstuAnswersBySstuIdAnswer = sstuAnswersBySstuIdAnswer;
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_question", referencedColumnName = "id_sstu_question", nullable = false)
    public SstuQuestionsEntity getSstuQuestionsBySstuIdQuestion() {
        return sstuQuestionsBySstuIdQuestion;
    }

    public void setSstuQuestionsBySstuIdQuestion(SstuQuestionsEntity sstuQuestionsBySstuIdQuestion) {
        this.sstuQuestionsBySstuIdQuestion = sstuQuestionsBySstuIdQuestion;
    }
}
