package com.luv2code.springboot.demo.myapp.persistence.hibernateImpl.dao.interfaces;

import java.util.List;

public interface IBaseDao<T> {

    List<T> findAll();

    T find(long id);

    T insert(T entity);

    T update(T entity);

    T delete(T entity);
}

