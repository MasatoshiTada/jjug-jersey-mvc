package com.example.persistence.dao;

import com.example.persistence.entity.Employee;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Dependent
public class EmployeeDao implements Serializable {
    @Inject
    private EntityManager em;
    
    @Transactional(Transactional.TxType.REQUIRED)
    public List<Employee> findAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class)
                .getResultList();
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Employee findByEmpId(Integer empId) {
        return em.createNamedQuery("Employee.findByEmpIdJoinFetchDepartment", Employee.class)
                .setParameter("empId", empId)
                .getSingleResult();
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public List<Employee> findByName(String nameKey) {
        return em.createNamedQuery("Employee.findByNameJoinFetchDepartment", Employee.class)
                .setParameter("name", "%" + nameKey + "%")
                .getResultList();
//        throw new RuntimeException("ERROR IN DAO!!!");
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Employee insert(Employee employee) {
        em.persist(employee);
        return employee;
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Employee update(Employee employee) {
        em.merge(employee);
        return employee;
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Integer deleteByEmpId(Integer empId) {
        return em.createNamedQuery("Employee.deleteByEmpId", Integer.class)
                .setParameter("empId", empId)
                .executeUpdate();
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Long countByEmpId(Integer empId) {
        return em.createNamedQuery("Employee.countByEmpId", Long.class)
                .setParameter("empId", empId)
                .getSingleResult();
    }
    
}
