package com.filimonenko.persistence;

import java.util.List;

public interface EmployeePersistence<Employee>  {

    List<Employee> findEmployersList(Long id);

    Employee findByID(Long id);

    void create(Employee employee);

    void update(Employee employee);

    void delete(Long Id);

    byte[] getImage(Long id);

    boolean getResume(Long id);
}
