//package com.filimonenko.persistence.impl.jdbc;
//
//import com.filimonenko.entity.Department;
//import com.filimonenko.persistence.DepartmentPersistence;
//import com.filimonenko.utils.ConnectionUtil;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class DepartmentPersistenceImpl implements DepartmentPersistence<Department> {
//
//    @Override
//    public List<Department> findDepartmentslist() {
//
//        List<Department> listOfDepartments = new ArrayList<>();
//        String inquiry = "select * from departments";
//
//        try (Connection connection = ConnectionUtil.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(inquiry)) {
//
//            while (resultSet.next()) {
//                Long departmentId = resultSet.getLong("department_id");
//                String departmentName = resultSet.getString("department_name");
//
//                Department department = new Department();
//
//                department.setDepartmentId(departmentId);
//                department.setDepartmentName(departmentName);
//
//                listOfDepartments.add(department);
//            }
//
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//
//        return listOfDepartments;
//    }
//
//    @Override
//    public Department findByID(Long id) {
//
//        String inquiry = "SELECT * FROM departments WHERE department_id=?";
//
//        Department department = null;
//
//
//        try (PreparedStatement preparedStatement = ConnectionUtil.getStatement(inquiry)) {
//
//            preparedStatement.setLong(1, id);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    String setDepartmentName = resultSet.getString("department_name");
//                    Long setDepartmentId = resultSet.getLong("department_id");
//
//                    department = new Department();
//                    department.setDepartmentId(setDepartmentId);
//                    department.setDepartmentName(setDepartmentName);
//                }
//            }
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//
//        return department;
//    }
//
//    @Override
//    public void create(Department department) {
//
//        String departmentName = department.getDepartmentName();
//        String inquiry = "INSERT INTO departments(department_name) VALUES (?)";
//
//        try (PreparedStatement preparedStatement = ConnectionUtil.getStatement(inquiry)) {
//
//            preparedStatement.setString(1, departmentName);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//    }
//
//    @Override
//    public void update(Department department) {
//
//        Long departmentId = department.getDepartmentId();
//        String newDepartmentName = department.getDepartmentName();
//        String inquiry = "UPDATE departments SET department_name=? WHERE department_id=?";
//
//        try (PreparedStatement preparedStatement = ConnectionUtil.getStatement(inquiry)) {
//
//            preparedStatement.setString(1, newDepartmentName);
//            preparedStatement.setString(2, String.valueOf(departmentId));
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException sx) {
//            sx.getMessage();
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//
//        String inquiry = "DELETE FROM departments WHERE department_id=?";
//
//        try (PreparedStatement preparedStatement = ConnectionUtil.getStatement(inquiry)) {
//
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException sx) {
//            sx.getMessage();
//        }
//    }
//}
