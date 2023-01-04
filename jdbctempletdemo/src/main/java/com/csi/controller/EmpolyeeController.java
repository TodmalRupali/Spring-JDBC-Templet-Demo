package com.csi.controller;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/")
public class EmpolyeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String sayHello(){
        return "Hello ....";
    }
    @PostMapping("/signup")
    public String signUp(@RequestBody Employee employee){
        String str = "Sign Up Done Successfully";
        for(Employee employee1 : employeeService.getAllData()){
            if(employee1.getEmpEmail().equals(employee.getEmpEmail())){
                return "User Already exit !! Please try with Another one....";
            }
        }
        employeeService.signUp(employee);
        return str;
    }
    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public String signIn(@PathVariable String empEmailId , @PathVariable String empPassword){
        String str = "";
        if(employeeService.signIn(empEmailId,empPassword)){
            return "SignIn Done Successfully";
        }else {
            return "Invalid credintial...Try Again.!!!";
        }
    }
    @GetMapping("/getbyid/{empId}")
    public Optional<Employee> getDataById(@PathVariable int empId){
        return Optional.ofNullable(employeeService.getDataById(empId));
    }
    @GetMapping("/getbyname/{empName}")
    public List<Employee> getDataByName(@PathVariable String empName){
        return employeeService.getDataByName(empName);
    }

    @GetMapping("/getbyemail/{empEmailId}")
    public  Employee gatDataByEmail(@PathVariable String empEmailId){
        return employeeService.getDataByEmail(empEmailId);
    }
    @GetMapping("/getbycontact/{empContact}")
    public Employee getDataByContact(@PathVariable long empContact){
        return employeeService.getDataByContactNumber(empContact);
    }
    @GetMapping("/getbyany/{input}")
    public Employee getDataByAnyInput(@PathVariable String input) {
        return employeeService.getDataByUsingAnyInput(input);
    }
    @GetMapping("/getall")
    public List<Employee> getAllData(){
        return  employeeService.getAllData();
    }
    @GetMapping("/sortbyname")
    public List<Employee> sortByName(){
        return   employeeService.sortByName();
    }
    @GetMapping("/sortbyid")
    public List<Employee> sortById(){
        return   employeeService.sortById();
    }
    @GetMapping("/sortbysalary")
    public List<Employee> sortBySalary(){
        return   employeeService.sortBySalary();
    }

    public List<Employee> sortByDOB(){
        return   employeeService.sortByDob();
    }
    @GetMapping("/filterbysalary/{empSalary}")
    public List<Employee> filterBySalary(@PathVariable double empSalary){
        return   employeeService.filterDataBySalary(empSalary);
    }
    @GetMapping("/loaneligibility/{input}")
    public String loanEligibility(@PathVariable String input) throws ParseException {
        if(employeeService.loanEligibility(input)){
            return "Eligible for Loan";
        }else {
            return "Not Eligible for Loan";
        }
    }
    @PutMapping("/update/{empId}")
    public  Employee updateData(@RequestBody Employee employee , @PathVariable int empId){
        return employeeService.update(empId,employee);

    }
    @DeleteMapping("/deletebyid/{empId}")
    public String deleteById(@PathVariable int empId){
        employeeService.deleteById(empId);
        return "Data Deleted Successfully";
    }
    @GetMapping("/fetchsecondlargestsalary")
    public Optional<Employee> getSecondLargestSalaryRecord(){
        return employeeService.fetchsecondlargestsalary();
    }
    @DeleteMapping("/deleteall")
    public String deleteAll(){
        employeeService.deleteAll();
        return "All Data Deleted successfully";
    }

}
