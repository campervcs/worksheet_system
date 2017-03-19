package sstu.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Доктор кто on 19.03.2017.
 */
@Entity
@Table(name = "sstu_pulpits")
public class SstuPulpitsEntity {
    private Long idSstuPulpit;
    private String sstuPulpit;
    private SstuInstitutesEntity sstuInstitutesByIdSstuInstitute;
    private Collection<SstuUsersEntity> sstuUsersesByIdSstuPulpit;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sstu_pulpit", nullable = false)
    public Long getIdSstuPulpit() {
        return idSstuPulpit;
    }

    public void setIdSstuPulpit(Long idSstuPulpit) {
        this.idSstuPulpit = idSstuPulpit;
    }

    @Basic
    @Column(name = "sstu_pulpit", nullable = false, length = 45)
    public String getSstuPulpit() {
        return sstuPulpit;
    }

    public void setSstuPulpit(String sstuPulpit) {
        this.sstuPulpit = sstuPulpit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SstuPulpitsEntity that = (SstuPulpitsEntity) o;

        if (idSstuPulpit != that.idSstuPulpit) return false;
        if (sstuPulpit != null ? !sstuPulpit.equals(that.sstuPulpit) : that.sstuPulpit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idSstuPulpit;
        result = 31 * result + (sstuPulpit != null ? sstuPulpit.hashCode() : 0);
        return (int)result.longValue();
    }

    @ManyToOne
    @JoinColumn(name = "id_sstu_institute", referencedColumnName = "id_sstu_institute", nullable = false)
    public SstuInstitutesEntity getSstuInstitutesByIdSstuInstitute() {
        return sstuInstitutesByIdSstuInstitute;
    }

    public void setSstuInstitutesByIdSstuInstitute(SstuInstitutesEntity sstuInstitutesByIdSstuInstitute) {
        this.sstuInstitutesByIdSstuInstitute = sstuInstitutesByIdSstuInstitute;
    }

    @OneToMany(mappedBy = "sstuPulpitsBySstuIdPulpit")
    public Collection<SstuUsersEntity> getSstuUsersesByIdSstuPulpit() {
        return sstuUsersesByIdSstuPulpit;
    }

    public void setSstuUsersesByIdSstuPulpit(Collection<SstuUsersEntity> sstuUsersesByIdSstuPulpit) {
        this.sstuUsersesByIdSstuPulpit = sstuUsersesByIdSstuPulpit;
    }
}
