package com.luv2code.springboot.demo.myapp.persistence.hibernateImpl.dao;

import com.luv2code.springboot.demo.myapp.persistence.hibernateImpl.dao.interfaces.IBaseDao;

import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public abstract class BaseDao<T> implements IBaseDao<T> {

    protected EntityManager _entityManager;
    protected CriteriaBuilder _builder;

    protected Session getSession() {
        return _entityManager.unwrap( Session.class );
    }
}
