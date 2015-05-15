package com.filimonenko.persistence;


import java.util.List;

public interface DepartmentPersistence<Department> {

    List<Department> findDepartmentslist();

    Department findByID(Long id);

    void create(Department department);

    void update(Department department);

    void delete(Long id);

}
