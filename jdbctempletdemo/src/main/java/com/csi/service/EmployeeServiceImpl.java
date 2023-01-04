package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;
    @Override
    public Employee signUp(Employee employee) {
        return employeeDao.signUp(employee);
    }

    @Override
    public boolean signIn(String empEmail, String empPass) {
        return employeeDao.signIn(empEmail,empPass);
    }

    @Override
    public Employee update(int empId ,Employee employee) {
        return employeeDao.update(empId,employee);
    }

    @Override
    public Employee getDataById(int empId) {
        return employeeDao.getDataById(empId);
    }

    @Override
    public List<Employee> getDataByName(String empName) {
        return employeeDao.getDataByName(empName);
    }

    @Override
    public Employee getDataByEmail(String empEmail) {
        return employeeDao.getDataByEmail(empEmail);
    }

    @Override
    public Employee getDataByContactNumber(long empContact) {
        return employeeDao.getDataByContactNumber(empContact);
    }

    @Override
    public Employee getDataByUsingAnyInput(String input) {
        return employeeDao.getDataByUsingAnyInput(input);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeDao.getAllData();
    }

    @Override
    public List<Employee> sortByName() {
        return employeeDao.sortByName();
    }

    @Override
    public List<Employee> sortById() {
        return employeeDao.sortById();
    }

    @Override
    public List<Employee> sortBySalary() {
        return employeeDao.sortBySalary();
    }

    @Override
    public List<Employee> sortByDob() {
        return employeeDao.sortByDob();
    }

    @Override
    public List<Employee> filterDataBySalary(double empSalary) {
        return employeeDao.filterDataBySalary(empSalary);
    }

    @Override
    public boolean loanEligibility(String input) {
        return employeeDao.loanEligibility(input);
    }

    @Override
    public Optional<Employee> fetchsecondlargestsalary() {
        return employeeDao.fetchsecondlargestsalary();
    }

    @Override
    public void deleteById(int empId) {
        employeeDao.deleteById(empId);
    }

    @Override
    public void deleteAll() {
        employeeDao.deleteAll();
    }
}
