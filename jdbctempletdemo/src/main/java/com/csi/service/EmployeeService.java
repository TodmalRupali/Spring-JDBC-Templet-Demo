package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee signUp(Employee employee);

    public boolean signIn(String empEmail , String empPass);

    public Employee update(Employee employee);

    public Employee getDataById(int empId);

    public List<Employee> getDataByName(String empName);

    public Employee getDataByEmail(String empEmail);

    public Employee getDataByContactNumber(long empContact);

    public Employee getDataByUsingAnyInput(String input);

    public List<Employee> getAllData();

    public List<Employee> sortByName();

    public List<Employee> sortById();

    public List<Employee> sortBySalary();

    public List<Employee>  sortByDob();

    public List<Employee> filterDataBySalary(double empSalary);

    public boolean loanEligibility(String input);

    public Employee fetchsecondlargestsalary();

    public  void deleteById(int empId);

    public void deleteAll();
}
