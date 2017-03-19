import sstu.dao.GenericDao;
import sstu.daoimpl.GenericDaoHibernateImpl;
import sstu.models.SstuRolesEntity;

/**
 * Created by Доктор кто on 19.03.2017.
 */
public class Main {


    public static void main(final String[] args) throws Exception {
            GenericDao<SstuRolesEntity> role=new GenericDaoHibernateImpl<SstuRolesEntity>(SstuRolesEntity.class);

            SstuRolesEntity userRole = new SstuRolesEntity();
            userRole.setSstuRole("Hui");
        System.out.println(role.read(1L));
        //userRole.setIdSstuRole(5L);
            System.out.println(role.create(userRole));
        role.delete(userRole);


    }
}