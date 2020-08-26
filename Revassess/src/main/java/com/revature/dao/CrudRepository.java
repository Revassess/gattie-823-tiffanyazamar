package com.revature.dao;

import java.util.Set;

import javax.validation.ReportAsSingleViolation;

public interface CrudRepository<T> {
	public T save(T t);
	public Set<T> findAll();
	public T findById(Integer id);
	public boolean update(T t);
	public boolean deleteById(Integer id);
}