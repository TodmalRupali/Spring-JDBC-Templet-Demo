package com.csi.dao;

import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    JdbcTemplate jdbcTemplate;
    String INSERT_SQL="insert into employees(empid, empname,empadd , empsalary,empcontact,empdate,empemail,emppass) value (?,?,?,?,?,?,?,?)";
    String SELECT_SQL= "select * from employees";
    String  UPDATE_SQL= "upadate employees set  empname=?,empadd=?,empsalary=?,empcontact=?,empdate=?,empemail=?,emppass=? where empid=?";
    String DELETE_SQL="delete from employees where empid=?";
    private Employee employee(ResultSet resultSet , int numRow) throws SQLException {
      return Employee.builder().empId(resultSet.getInt(1)).empName(resultSet.getString(2)).empAdd(resultSet.getString(3)).empSalary(resultSet.getDouble(4)).empContact(resultSet.getLong(5)).empDob(resultSet.getDate(6)).empEmail(resultSet.getString(7)).empPass(resultSet.getString(8)).build();
    }
    @Override
    public Employee signUp(Employee employee) {
         jdbcTemplate.update(INSERT_SQL, employee.getEmpId(),employee.getEmpName(),employee.getEmpAdd(),employee.getEmpSalary(),employee.getEmpContact(),employee.getEmpDob(),employee.getEmpEmail(),employee.getEmpPass());
         return employee;
    }

    @Override
    public boolean signIn(String empEmail, String empPass) {
        boolean flag = false;
        for(Employee employee : getAllData()){
            if(employee.getEmpEmail().equals(empEmail) && employee.getEmpPass().equals(empPass)){
                flag=true;
            }
        }

        return flag;
    }

    @Override
    public Employee update(int empId, Employee employee) {

        jdbcTemplate.update(UPDATE_SQL ,employee.getEmpName(),employee.getEmpAdd(),employee.getEmpSalary(),employee.getEmpContact(),employee.getEmpDob(),employee.getEmpEmail(),employee.getEmpPass() ,empId);
        return employee;
    }

    @Override
    public Employee getDataById(int empId) {

       return (Employee) jdbcTemplate.query("select * from employees where empid=?", this::employee,empId);

    }

    @Override
    public List<Employee> getDataByName(String empName) {
        return jdbcTemplate.query("select * from employees where empname=?", this::employee,empName);
    }

    @Override
    public Employee getDataByEmail(String empEmail) {
        return (Employee) jdbcTemplate.query("select * from employees where empemail=?", this::employee,empEmail);
    }

    @Override
    public Employee getDataByContactNumber(long empContact) {
        return (Employee) jdbcTemplate.query("select * from employees where empcontact=?", this::employee,empContact);
    }

    @Override
    public Employee getDataByUsingAnyInput(String input) {
        for(Employee employee : getAllData()){
            if(employee.getEmpName().equals(input) || employee.getEmpEmail().equals(input) || String.valueOf(employee.getEmpId()).equals(input) || String.valueOf(employee.getEmpContact()).equals(input) || String.valueOf(employee.getEmpSalary()).equals(input)){
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllData() {
        return jdbcTemplate.query(SELECT_SQL, this::employee);
    }

    @Override
    public List<Employee> sortByName() {
        return getAllData().stream().sorted((e1 , e2) -> e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortById() {
        return getAllData().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortBySalary() {
        return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByDob() {
        return null;
    }

    @Override
    public List<Employee> filterDataBySalary(double empSalary) {
        return getAllData().stream().filter(emp->emp.getEmpSalary()>=empSalary).collect(Collectors.toList());
    }

    @Override
    public boolean loanEligibility(String input) {

        boolean flag = false;
        for (Employee employee : getAllData()) {
            if (employee.getEmpName().equals(input) || employee.getEmpEmail().equals(input) || String.valueOf(employee.getEmpId()).equals(input) || String.valueOf(employee.getEmpContact()).equals(input) || String.valueOf(employee.getEmpSalary()).equals(input)) {
                if (employee.getEmpSalary() >= 5000) {
                    flag = true;
                }
            }

        }
        return flag;
    }
    @Override
    public Optional<Employee> fetchsecondlargestsalary() {
        return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary).reversed()).skip(1).findFirst();
    }

    @Override
    public void deleteById(int empId) {
      jdbcTemplate.update(DELETE_SQL ,empId);
    }

    @Override
    public void deleteAll() {
      jdbcTemplate.update("delete from employee");
    }
}
