package br.com.lopes.dao;

import java.util.List;

public interface DAO {

	public void insert(Object t);
	public void update(Object t);
	public void delete(Object t);
	public List<Object> list();
}
