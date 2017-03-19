package sstu.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Доктор кто on 19.03.2017.
 */
@Entity
@Table(name = "sstu_users")
public class SstuUsersEntity {
    private Long idSstuUser;
    private String sstuFirstName;
    private String sstuLastName;
    private String sstuLogin;
    private String sstuPassword;
    private String sstuMail;
    private Collection<SstuResultsEntity> sstuResultsesByIdSstuUser;
    private SstuPulpitsEntity sstuPulpitsBySstuIdPulpit;
    private SstuRolesEntity sstuRolesBySstuIdRole;
    private Collection<SstuWorksheetsEntity> sstuWorksheetsesByIdSstuUser;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sstu_user", nullable = false)
    public Long getIdSstuUser() {
        return idSstuUser;
    }

    public void setIdSstuUser(Long idSstuUser) {
        this.idSstuUser = idSstuUser;
    }

    @Basic
    @Column(name = "sstu_first_name", nullable = false, length = 45)
    public String getSstuFirstName() {
        return sstuFirstName;
    }

    public void setSstuFirstName(String sstuFirstName) {
        this.sstuFirstName = sstuFirstName;
    }

    @Basic
    @Column(name = "sstu_last_name", nullable = false, length = 45)
    public String getSstuLastName() {
        return sstuLastName;
    }

    public void setSstuLastName(String sstuLastName) {
        this.sstuLastName = sstuLastName;
    }

    @Basic
    @Column(name = "sstu_login", nullable = false, length = 45)
    public String getSstuLogin() {
        return sstuLogin;
    }

    public void setSstuLogin(String sstuLogin) {
        this.sstuLogin = sstuLogin;
    }

    @Basic
    @Column(name = "sstu_password", nullable = false, length = 45)
    public String getSstuPassword() {
        return sstuPassword;
    }

    public void setSstuPassword(String sstuPassword) {
        this.sstuPassword = sstuPassword;
    }

    @Basic
    @Column(name = "sstu_mail", nullable = true, length = 45)
    public String getSstuMail() {
        return sstuMail;
    }

    public void setSstuMail(String sstuMail) {
        this.sstuMail = sstuMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SstuUsersEntity that = (SstuUsersEntity) o;

        if (idSstuUser != that.idSstuUser) return false;
        if (sstuFirstName != null ? !sstuFirstName.equals(that.sstuFirstName) : that.sstuFirstName != null)
            return false;
        if (sstuLastName != null ? !sstuLastName.equals(that.sstuLastName) : that.sstuLastName != null) return false;
        if (sstuLogin != null ? !sstuLogin.equals(that.sstuLogin) : that.sstuLogin != null) return false;
        if (sstuPassword != null ? !sstuPassword.equals(that.sstuPassword) : that.sstuPassword != null) return false;
        if (sstuMail != null ? !sstuMail.equals(that.sstuMail) : that.sstuMail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idSstuUser;
        result = 31 * result + (sstuFirstName != null ? sstuFirstName.hashCode() : 0);
        result = 31 * result + (sstuLastName != null ? sstuLastName.hashCode() : 0);
        result = 31 * result + (sstuLogin != null ? sstuLogin.hashCode() : 0);
        result = 31 * result + (sstuPassword != null ? sstuPassword.hashCode() : 0);
        result = 31 * result + (sstuMail != null ? sstuMail.hashCode() : 0);
        return (int)result.longValue();
    }

    @OneToMany(mappedBy = "sstuUsersBySstuIdUser")
    public Collection<SstuResultsEntity> getSstuResultsesByIdSstuUser() {
        return sstuResultsesByIdSstuUser;
    }

    public void setSstuResultsesByIdSstuUser(Collection<SstuResultsEntity> sstuResultsesByIdSstuUser) {
        this.sstuResultsesByIdSstuUser = sstuResultsesByIdSstuUser;
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_pulpit", referencedColumnName = "id_sstu_pulpit", nullable = false)
    public SstuPulpitsEntity getSstuPulpitsBySstuIdPulpit() {
        return sstuPulpitsBySstuIdPulpit;
    }

    public void setSstuPulpitsBySstuIdPulpit(SstuPulpitsEntity sstuPulpitsBySstuIdPulpit) {
        this.sstuPulpitsBySstuIdPulpit = sstuPulpitsBySstuIdPulpit;
    }

    @ManyToOne
    @JoinColumn(name = "sstu_id_role", referencedColumnName = "id_sstu_role", nullable = false)
    public SstuRolesEntity getSstuRolesBySstuIdRole() {
        return sstuRolesBySstuIdRole;
    }

    public void setSstuRolesBySstuIdRole(SstuRolesEntity sstuRolesBySstuIdRole) {
        this.sstuRolesBySstuIdRole = sstuRolesBySstuIdRole;
    }

    @OneToMany(mappedBy = "sstuUsersBySstuIdUser")
    public Collection<SstuWorksheetsEntity> getSstuWorksheetsesByIdSstuUser() {
        return sstuWorksheetsesByIdSstuUser;
    }

    public void setSstuWorksheetsesByIdSstuUser(Collection<SstuWorksheetsEntity> sstuWorksheetsesByIdSstuUser) {
        this.sstuWorksheetsesByIdSstuUser = sstuWorksheetsesByIdSstuUser;
    }
}
