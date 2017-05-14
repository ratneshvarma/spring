package com.spring.mvc.dao;

import com.spring.mvc.model.Emp;

import java.util.List;

/**
 * Created by ratnesh on 14/5/17.
 */
public interface EmpDao {
    int insertEmp(Emp emp);
    List allEmp();
}
