package sstu.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Доктор кто on 19.03.2017.
 */
@Entity
@Table(name = "sstu_roles")
public class SstuRolesEntity {
    private Long idSstuRole;
    private String sstuRole;
    private Collection<SstuUsersEntity> sstuUsersesByIdSstuRole;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_sstu_role", nullable = false)
    public Long getIdSstuRole() {
        return idSstuRole;
    }

    public void setIdSstuRole(Long idSstuRole) {
        this.idSstuRole = idSstuRole;
    }

    @Basic
    @Column(name = "sstu_role", nullable = false, length = 45)
    public String getSstuRole() {
        return sstuRole;
    }

    public void setSstuRole(String sstuRole) {
        this.sstuRole = sstuRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SstuRolesEntity that = (SstuRolesEntity) o;

        if (idSstuRole != that.idSstuRole) return false;
        if (sstuRole != null ? !sstuRole.equals(that.sstuRole) : that.sstuRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idSstuRole;
        result = 31 * result + (sstuRole != null ? sstuRole.hashCode() : 0);
        return (int)result.longValue();
    }

    @OneToMany(mappedBy = "sstuRolesBySstuIdRole")
    public Collection<SstuUsersEntity> getSstuUsersesByIdSstuRole() {
        return sstuUsersesByIdSstuRole;
    }

    public void setSstuUsersesByIdSstuRole(Collection<SstuUsersEntity> sstuUsersesByIdSstuRole) {
        this.sstuUsersesByIdSstuRole = sstuUsersesByIdSstuRole;
    }
}
