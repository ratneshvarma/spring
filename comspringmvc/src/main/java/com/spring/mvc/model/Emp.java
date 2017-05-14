package com.spring.mvc.model;

import org.springframework.stereotype.Component;

/**
 * Created by ratnesh on 14/5/17.
 */
@Component
public class Emp {
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    private int empId;
    private String empName;
    private String empAddress;
}
