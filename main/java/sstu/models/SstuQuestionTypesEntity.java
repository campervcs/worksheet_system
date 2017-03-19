package sstu.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Доктор кто on 19.03.2017.
 */
@Entity
@Table(name = "sstu_question_types")
public class SstuQuestionTypesEntity {
    private Long idSstuQuestionType;
    private String sstuQuestionType;
    private Collection<SstuQuestionsEntity> sstuQuestionsesByIdSstuQuestionType;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sstu_question_type", nullable = false)
    public Long getIdSstuQuestionType() {
        return idSstuQuestionType;
    }

    public void setIdSstuQuestionType(Long idSstuQuestionType) {
        this.idSstuQuestionType = idSstuQuestionType;
    }

    @Basic
    @Column(name = "sstu_question_type", nullable = false, length = 45)
    public String getSstuQuestionType() {
        return sstuQuestionType;
    }

    public void setSstuQuestionType(String sstuQuestionType) {
        this.sstuQuestionType = sstuQuestionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SstuQuestionTypesEntity that = (SstuQuestionTypesEntity) o;

        if (idSstuQuestionType != that.idSstuQuestionType) return false;
        if (sstuQuestionType != null ? !sstuQuestionType.equals(that.sstuQuestionType) : that.sstuQuestionType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idSstuQuestionType;
        result = 31 * result + (sstuQuestionType != null ? sstuQuestionType.hashCode() : 0);
        return (int)result.longValue();
    }

    @OneToMany(mappedBy = "sstuQuestionTypesBySstuIdQuestionType")
    public Collection<SstuQuestionsEntity> getSstuQuestionsesByIdSstuQuestionType() {
        return sstuQuestionsesByIdSstuQuestionType;
    }

    public void setSstuQuestionsesByIdSstuQuestionType(Collection<SstuQuestionsEntity> sstuQuestionsesByIdSstuQuestionType) {
        this.sstuQuestionsesByIdSstuQuestionType = sstuQuestionsesByIdSstuQuestionType;
    }
}
