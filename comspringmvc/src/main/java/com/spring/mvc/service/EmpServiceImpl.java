package com.spring.mvc.service;

import com.spring.mvc.dao.EmpDao;
import com.spring.mvc.dao.EmpDaoImpl;
import com.spring.mvc.model.Emp;
import com.spring.mvc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ratnesh on 14/5/17.
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpDao empDao;
    public int empInsert(Emp emp) {
     return empDao.insertEmp(emp);

    }

    public int empDelete(int empId) {
        return empDao.deleteEmp(empId);
    }

    public int empUpdate(Emp emp) {
        return empDao.updateEmp(emp);
    }

    public List getAllEmp() {
       return empDao.allEmp();
    }

    public Emp getSpecificEmp(int empId) {
        return empDao.getEmp(empId);
    }
}
