package sstu.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Доктор кто on 19.03.2017.
 */
@Entity
@Table(name = "sstu_worksheets")
public class SstuWorksheetsEntity {
    private Long idSstuWorksheet;
    private String sstuWorksheetTitle;
    private Timestamp sstuWorksheetDateOfCreation;
    private Collection<SstuQuestionsEntity> sstuQuestionsesByIdSstuWorksheet;
    private Collection<SstuResultsEntity> sstuResultsesByIdSstuWorksheet;
    private SstuUsersEntity sstuUsersBySstuIdUser;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sstu_worksheet", nullable = false)
    public Long getIdSstuWorksheet() {
        return idSstuWorksheet;
    }

    public void setIdSstuWorksheet(Long idSstuWorksheet) {
        this.idSstuWorksheet = idSstuWorksheet;
    }

    @Basic
    @Column(name = "sstu_worksheet_title", nullable = false, length = 45)
    public String getSstuWorksheetTitle() {
        return sstuWorksheetTitle;
    }

    public void setSstuWorksheetTitle(String sstuWorksheetTitle) {
        this.sstuWorksheetTitle = sstuWorksheetTitle;
    }

    @Basic
    @Column(name = "sstu_worksheet_date_of_creation", nullable = false)
    public Timestamp getSstuWorksheetDateOfCreation() {
        return sstuWorksheetDateOfCreation;
    }

    public void setSstuWorksheetDateOfCreation(Timestamp sstuWorksheetDateOfCreation) {
        this.sstuWorksheetDateOfCreation = sstuWorksheetDateOfCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SstuWorksheetsEntity that = (SstuWorksheetsEntity) o;

        if (idSstuWorksheet != that.idSstuWorksheet) return false;
        if (sstuWorksheetTitle != null ? !sstuWorksheetTitle.equals(that.sstuWorksheetTitle) : that.sstuWorksheetTitle != null)
            return false;
        if (sstuWorksheetDateOfCreation != null ? !sstuWorksheetDateOfCreation.equals(that.sstuWorksheetDateOfCreation) : that.sstuWorksheetDateOfCreation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idSstuWorksheet;
        result = 31 * result + (sstuWorksheetTitle != null ? sstuWorksheetTitle.hashCode() : 0);
        result = 31 * result + (sstuWorksheetDateOfCreation != null ? sstuWorksheetDateOfCreation.hashCode() : 0);
        return (int)result.longValue();
    }

    @OneToMany(mappedBy = "sstuWorksheetsBySstuIdWorksheet")
    public Collection<SstuQuestionsEntity> getSstuQuestionsesByIdSstuWorksheet() {
        return sstuQuestionsesByIdSstuWorksheet;
    }

    public void setSstuQuestionsesByIdSstuWorksheet(Collection<SstuQuestionsEntity> sstuQuestionsesByIdSstuWorksheet) {
        this.sstuQuestionsesByIdSstuWorksheet = sstuQuestionsesByIdSstuWorksheet;
    }

    @OneToMany(mappedBy = "sstuWorksheetsBySstuIdWorksheet")
    public Collection<SstuResultsEntity> getSstuResultsesByIdSstuWorksheet() {
        return sstuResultsesByIdSstuWorksheet;
    }

    public void setSstuResultsesByIdSstuWorksheet(Collection<SstuResultsEntity> sstuResultsesByIdSstuWorksheet) {
        this.sstuResultsesByIdSstuWorksheet = sstuResultsesByIdSstuWorksheet;
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_user", referencedColumnName = "id_sstu_user", nullable = false)
    public SstuUsersEntity getSstuUsersBySstuIdUser() {
        return sstuUsersBySstuIdUser;
    }

    public void setSstuUsersBySstuIdUser(SstuUsersEntity sstuUsersBySstuIdUser) {
        this.sstuUsersBySstuIdUser = sstuUsersBySstuIdUser;
    }
}
