package com.spring.mvc.dao;

import com.spring.mvc.model.Emp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ratnesh on 14/5/17.
 */
//@Repository //not user Repository if you configure tha connection from bean definition in XML
public class EmpDaoImpl implements EmpDao {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    public int insertEmp(Emp emp) {
        String sql="insert into employee(empId,empName,empAddress) values("+emp.getEmpId()+",'"+emp.getEmpName()+"','"+emp.getEmpAddress()+"')";
        int flag= jdbcTemplate.update(sql);
        if (flag>0)
            System.out.println("Employee Inserted..");
        return flag;
    }

    public int deleteEmp(int empId) {
        String sql="DELETE FROM employee WHERE empId="+empId ;
        int flag= jdbcTemplate.update(sql);
        if (flag>0)
            System.out.println("Employee deleted..");
        return flag;
    }

    public Emp getEmp(int empId) {
        return jdbcTemplate.queryForObject("select * from employee where empId=" + empId, new RowMapper<Emp>() {
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp= new Emp();
                emp.setEmpId(resultSet.getInt("empId"));
                emp.setEmpName(resultSet.getString("empName"));
                emp.setEmpAddress(resultSet.getString("empAddress"));
                return emp;
            }
        });
    }

    public int updateEmp(Emp emp) {
        String sql="update employee SET empName='"+ emp.getEmpName() +"', empAddress='"+ emp.getEmpAddress() +"' WHERE empId="+ emp.getEmpId() ;
        int flag= jdbcTemplate.update(sql);
        if (flag>0)
            System.out.println("Employee deleted..");
        return flag;
    }

    public List allEmp() {
       return jdbcTemplate.query("select * from employee", new RowMapper() {
           public Object mapRow(ResultSet resultSet, int i) throws SQLException {
               Emp emp=new Emp();
               emp.setEmpId(resultSet.getInt("empId"));
               emp.setEmpName(resultSet.getString("empName"));
               emp.setEmpAddress(resultSet.getString("empAddress"));
               System.out.println("Emp NAME: "+ resultSet.getString("empName"));
               return emp;
           }
       });


    }
}
