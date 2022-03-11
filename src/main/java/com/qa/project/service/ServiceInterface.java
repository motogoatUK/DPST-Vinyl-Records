package com.qa.project.service;


import java.util.List;

public interface ServiceInterface<T> {

	T create(T t);

	List<T> readAll();

	T readById(int id);

	T update(int id, T t);

	boolean delete(int id); // returns true if successfully deleted


}
