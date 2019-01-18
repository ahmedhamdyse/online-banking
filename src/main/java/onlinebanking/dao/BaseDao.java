package onlinebanking.dao;

import java.util.List;

public interface BaseDao<T> {

	void add(T t);

	boolean remove(T t);

	T find(long id);

	List<T> findAll();

}
