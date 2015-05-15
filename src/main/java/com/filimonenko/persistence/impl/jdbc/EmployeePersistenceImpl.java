//package com.filimonenko.persistence.impl.jdbc;
//
//import com.filimonenko.entity.Employee;
//import com.filimonenko.persistence.EmployeePersistence;
//import com.filimonenko.utils.ConnectionUtil;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Repository
//public class EmployeePersistenceImpl implements EmployeePersistence<Employee> {
//
//
//    @Override
//    public List<Employee> findEmployersList(Long departmentID) {
//
//        List<Employee> listOfStaff = new ArrayList<>();
//
//        String inquiry = "select * from departments JOIN staff USING (department_id) WHERE department_id=?";
//
//
//        try (PreparedStatement preparedStatement = ConnectionUtil.getStatement(inquiry)) {
//
//            preparedStatement.setLong(1, departmentID);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//
//                while (resultSet.next()) {
//
//                    Long employeeId = resultSet.getLong("employee_id");
//                    Long departmentId = resultSet.getLong("department_id");
//                    String name = resultSet.getString("employee_name");
//                    java.util.Date uDate = resultSet.getDate("employee_dob");
//                    String mailBox = resultSet.getString("employee_mailBox");
//
//                    Employee employee = new Employee();
//
//                    employee.setId(employeeId);
//                    employee.setDepartmentId(departmentId);
//                    employee.setName(name);
//                    employee.setBirthDate(uDate);
//                    employee.setEmail(mailBox);
//
//                    listOfStaff.add(employee);
//                }
//            }
//
//        } catch (SQLException sx) {
//            sx.getMessage();
//        }
//
//        return listOfStaff;
//    }
//
//    @Override
//    public Employee findByID(Long employeeID) {
//
//        String inquiry = "SELECT * FROM staff WHERE employee_id=?";
//
//        Employee employee = null;
//
//        try (PreparedStatement preparedStatement = ConnectionUtil.getStatement(inquiry)) {
//
//            preparedStatement.setLong(1, employeeID);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//
//                while (resultSet.next()) {
//
//                    Long departmentId = resultSet.getLong("department_id");
//                    Long employeeId = resultSet.getLong("employee_id");
//                    String employeeName = resultSet.getString("employee_name");
//                    Date date = resultSet.getDate("employee_dob");
//                    String employee_MailBox = resultSet.getString("employee_MailBox");
//
//
//                    employee = new Employee();
//                    employee.setDepartmentId(departmentId);
//                    employee.setId(employeeId);
//                    employee.setName(employeeName);
//                    employee.setBirthDate(date);
//                    employee.setEmail(employee_MailBox);
//                }
//            }
//
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//        return employee;
//    }
//
//    @Override
//    public void create(Employee employee) {
//
//        String inquiry = "INSERT INTO staff(department_id,employee_name,employee_dob,employee_MailBox) VALUES (?,?,?,?)";
//
//        Long departmentId = employee.getDepartmentId();
//        String employeeName = employee.getName();
//        Date uDate = employee.getBirthDate();
//        java.sql.Date sqlDate = uDateToSqlDate(uDate);
//        String employeeMailBox = employee.getEmail();
//
//        try (PreparedStatement preparedStatement = ConnectionUtil.getStatement(inquiry)) {
//            preparedStatement.setLong(1, departmentId);
//            preparedStatement.setString(2, employeeName);
//            preparedStatement.setDate(3, sqlDate);
//            preparedStatement.setString(4, employeeMailBox);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//    }
//
//    @Override
//    public void update(Employee employee) {
//
//        Long departmentId = employee.getDepartmentId();
//        Long employeeId = employee.getId();
//        String employeeName = employee.getName();
//        Date date = employee.getBirthDate();
//        java.sql.Date sqlDate = uDateToSqlDate(date);
//        String employeeMailBox = employee.getEmail();
//
//        String inquiry = "UPDATE staff SET  employee_name=?, employee_dob=?, employee_MailBox=?, department_id=?  WHERE employee_id=?";
//
//        try (PreparedStatement preparedStatement = ConnectionUtil.getStatement(inquiry)) {
//
//            preparedStatement.setString(1, employeeName);
//            preparedStatement.setDate(2, sqlDate);
//            preparedStatement.setString(3, employeeMailBox);
//            preparedStatement.setLong(4, departmentId);
//            preparedStatement.setLong(5, employeeId);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException sx) {
//            sx.getMessage();
//        }
//    }
//
//    @Override
//    public void delete(Long employeeId) {
//
//        String inquiry = "DELETE FROM staff WHERE employee_id=?";
//
//
//        try (PreparedStatement preparedStatement = ConnectionUtil.getStatement(inquiry)) {
//            preparedStatement.setLong(1, employeeId);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException sx) {
//            sx.getMessage();
//        }
//    }
//
//    private java.sql.Date uDateToSqlDate(Date date) {
//        return new java.sql.Date(date.getTime());
//    }
//}
