package com.spring.mvc.service;

import com.spring.mvc.model.Emp;

import java.util.List;

/**
 * Created by ratnesh on 14/5/17.
 */
public interface EmpService {
 int empInsert(Emp emp);
 int empDelete(int empId);
 int empUpdate(Emp emp);
 List getAllEmp();
 Emp getSpecificEmp(int empId);
}
