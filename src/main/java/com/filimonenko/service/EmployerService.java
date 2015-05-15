package com.filimonenko.service;

import java.util.List;

/**
 * Date: 26.09.13
 * Time: 17:35
 */

public interface EmployerService<Employee> {


    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    List<Employee> getEmployersList(Long id);
    Employee getEmployeeById(Long id);
    byte[] getImage(Long id);
    boolean getResume(Long id);
}
