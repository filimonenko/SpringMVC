package com.filimonenko.service;


import java.util.List;

public interface DepartmentService<Department> {

    void createDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(Long id);

    List<Department> getDepartmentslist();

    Department getDepartmentById(Long id);

}
