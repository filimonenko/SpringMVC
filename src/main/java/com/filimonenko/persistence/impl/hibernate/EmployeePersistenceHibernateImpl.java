package com.filimonenko.persistence.impl.hibernate;

import com.filimonenko.entity.Employee;
import com.filimonenko.persistence.EmployeePersistence;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeePersistenceHibernateImpl implements EmployeePersistence<Employee> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> findEmployersList(Long id) {

        List<Employee> list = em.createQuery("from Employee where departmentId= :depId", Employee.class)
                .setParameter("depId", id)
//                .setParameter("depId", id)
                .getResultList();

        return list;
    }

    @Override
    public Employee findByID(Long id) {

        return em.find(Employee.class, id);
    }

    @Override
    public void create(Employee employee) {

        em.persist(employee);
    }

    @Override
    public void update(Employee employee) {

        em.merge(employee);
    }

    @Override
    public void delete(Long Id) {
        Employee employee = new Employee();
        employee.setId(Id);

        em.remove(em.merge(employee));
    }

    @Override
    public byte[] getImage(Long id) {

        Employee employee = em.find(Employee.class, id);

        return employee.getImage();

    }

    @Override
    public boolean getResume(Long id) {

        Employee employee = em.find(Employee.class, id);

        return employee.getResume();
    }
}

