package sstu.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Доктор кто on 19.03.2017.
 */
@Entity
@Table(name = "sstu_institutes")
public class SstuInstitutesEntity {
    private Long idSstuInstitute;
    private String sstuInstitute;
    private Collection<SstuPulpitsEntity> sstuPulpitsesByIdSstuInstitute;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sstu_institute", nullable = false)
    public Long getIdSstuInstitute() {
        return idSstuInstitute;
    }

    public void setIdSstuInstitute(Long idSstuInstitute) {
        this.idSstuInstitute = idSstuInstitute;
    }

    @Basic
    @Column(name = "sstu_institute", nullable = false, length = 45)
    public String getSstuInstitute() {
        return sstuInstitute;
    }

    public void setSstuInstitute(String sstuInstitute) {
        this.sstuInstitute = sstuInstitute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SstuInstitutesEntity that = (SstuInstitutesEntity) o;

        if (idSstuInstitute != that.idSstuInstitute) return false;
        if (sstuInstitute != null ? !sstuInstitute.equals(that.sstuInstitute) : that.sstuInstitute != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idSstuInstitute;
        result = 31 * result + (sstuInstitute != null ? sstuInstitute.hashCode() : 0);
        return (int)result.longValue();
    }

    @OneToMany(mappedBy = "sstuInstitutesByIdSstuInstitute")
    public Collection<SstuPulpitsEntity> getSstuPulpitsesByIdSstuInstitute() {
        return sstuPulpitsesByIdSstuInstitute;
    }

    public void setSstuPulpitsesByIdSstuInstitute(Collection<SstuPulpitsEntity> sstuPulpitsesByIdSstuInstitute) {
        this.sstuPulpitsesByIdSstuInstitute = sstuPulpitsesByIdSstuInstitute;
    }
}
