package sstu.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import sstu.models.*;

/**
 * Created by Доктор кто on 19.03.2017.
 */
public class HibernateUtils {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;
    private static Session session;
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure().addAnnotatedClass(SstuRolesEntity.class)
                    .addAnnotatedClass(SstuUsersEntity.class)
                    .addAnnotatedClass(SstuAnswersEntity.class)
                    .addAnnotatedClass(SstuInstitutesEntity.class)
                    .addAnnotatedClass(SstuPulpitsEntity.class)
                    .addAnnotatedClass(SstuQuestionsEntity.class)
                    .addAnnotatedClass(SstuQuestionTypesEntity.class)
                    .addAnnotatedClass(SstuResultsEntity.class)
                    .addAnnotatedClass(SstuWorksheetsEntity.class);

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        session = ourSessionFactory.openSession();
        return session;
    }

    public static void shutdown() {
        // Close caches and connection pools
        session.close();
    }
}
