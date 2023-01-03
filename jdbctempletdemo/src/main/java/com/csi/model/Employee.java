package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    private  int empId;
    private String empName;
    private String empAdd;
    private  double empSalary;
    private long empContact;
    private Date empDob;
    private  String empEmail;
    private String empPass;
}
