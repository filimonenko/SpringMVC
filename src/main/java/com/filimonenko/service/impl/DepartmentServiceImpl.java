package com.filimonenko.service.impl;

import com.filimonenko.persistence.DepartmentPersistence;
import com.filimonenko.entity.Department;
import com.filimonenko.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService<Department> {

    @Qualifier("departmentPersistence")
    @Autowired
    private DepartmentPersistence persistence;

    @Transactional
    @Override
    public void createDepartment(Department department) {
        persistence.create(department);
    }

    @Transactional
    @Override
    public void updateDepartment(Department department) {
        persistence.update(department);
    }

    @Transactional
    @Override
    public void deleteDepartment(Long id) {
        persistence.delete(id);
    }

    @Override
    public List<Department> getDepartmentslist() {
        return persistence.findDepartmentslist();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return (Department) persistence.findByID(id);
    }
}
