package com.filimonenko.service.impl;

import com.filimonenko.persistence.EmployeePersistence;
import com.filimonenko.entity.Employee;
import com.filimonenko.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService<Employee> {

    @Qualifier("employeePersistence")
    @Autowired
    private EmployeePersistence persistence;

    @Transactional
    @Override
    public void createEmployee(Employee employee) {
        persistence.create(employee);
    }

    @Transactional
    @Override
    public void updateEmployee(Employee employee) {
        persistence.update(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(Long id) {
        persistence.delete(id);
    }

    @Override
    public List<Employee> getEmployersList(Long id) {
        return persistence.findEmployersList(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return (Employee) persistence.findByID(id);
    }

    @Override
    public byte[] getImage(Long id) {
        return persistence.getImage(id);
    }

    @Override
    public boolean getResume(Long id) {
        return persistence.getResume(id);
    }


}
