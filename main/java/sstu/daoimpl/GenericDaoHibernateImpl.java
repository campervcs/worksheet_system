package sstu.daoimpl;

import org.hibernate.Session;
import sstu.dao.GenericDao;
import sstu.hibernate.HibernateUtils;


import static sstu.hibernate.HibernateUtils.getSession;

public class GenericDaoHibernateImpl<T>
        implements GenericDao<T> {
    private Class<T> type;

    public GenericDaoHibernateImpl(Class<T> type) {
        this.type = type;
    }

    public Long create(T o) {
        Session session = getSession();
        session.beginTransaction();
        Long result = (Long) session.save(o);
        session.getTransaction().commit();
        HibernateUtils.shutdown();
        return result;

    }

    public T read(Long id) {
        Session session = getSession();
        T result = session.get(type, id);
        HibernateUtils.shutdown();
        return result;
    }

    public void update(T o) {
        Session session = getSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        HibernateUtils.shutdown();
    }

    public void delete(T o) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        HibernateUtils.shutdown();
    }
}
