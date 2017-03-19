package sstu.dao;

public interface GenericDao<T> {
    public Long create(T o);

    public T read(Long id);

    public void update(T o);

    public void delete(T o);
}
