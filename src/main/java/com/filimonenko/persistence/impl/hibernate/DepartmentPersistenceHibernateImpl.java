package com.filimonenko.persistence.impl.hibernate;

import com.filimonenko.entity.Department;
import com.filimonenko.persistence.DepartmentPersistence;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentPersistenceHibernateImpl implements DepartmentPersistence<Department> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Department> findDepartmentslist() {

        return em.createQuery("FROM Department", Department.class).getResultList();
    }

    @Override
    public void create(Department department) {

        em.persist(department);
    }

    @Override
    public Department findByID(Long id) {

        return em.find(Department.class, id);
    }

    @Override
    public void update(Department department) {

        em.merge(department);
    }

    @Override
    public void delete(Long id) {
        Department department = new Department();
        department.setDepartmentId(id);

        em.remove(em.merge(department));
    }
}
