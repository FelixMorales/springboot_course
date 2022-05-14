package com.luv2code.springboot.demo.myapp.persistence.hibernateImpl.dao;

import com.luv2code.springboot.demo.myapp.common.entities.Employee;
import com.luv2code.springboot.demo.myapp.persistence.hibernateImpl.dao.interfaces.IEmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao {

    @Autowired
    public EmployeeDao(EntityManager em) {
        _entityManager = em;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> result;

        CriteriaQuery<Employee> criteriaQuery;
        Root<Employee> root;

        criteriaQuery = getSession().getCriteriaBuilder().createQuery( Employee.class );

        root = criteriaQuery.from( Employee.class );
        criteriaQuery.select( root );

        result = getSession().createQuery( criteriaQuery ).getResultList();

        return result;
    }

    @Override
    public Employee find(long id) {
        Employee result;

        result = getSession().find( Employee.class, id );

        return result;
    }

    @Override
    public Employee insert(Employee entity) {
        getSession().persist( entity );

        return entity;
    }

    @Override
    public Employee update(Employee entity) {
        getSession().merge( entity );

        return entity;
    }

    @Override
    public Employee delete(Employee entity) {
        getSession().delete( entity );

        return entity;
    }

    @Override
    public Employee findByEmail(String email) {
        _builder = getSession().getCriteriaBuilder();

        CriteriaQuery<Employee> query = _builder.createQuery( Employee.class );
        Root<Employee> root = query.from( Employee.class );

        query.select( root );
        query.where( _builder.equal( root.get( "_email" ), email ) );

        return getSession().createQuery( query ).getResultStream().findFirst().orElse(null);
    }
}
