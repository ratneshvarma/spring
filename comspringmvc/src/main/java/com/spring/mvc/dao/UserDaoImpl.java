package com.spring.mvc.dao;

import com.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ratnesh on 14/5/17.
 */

//@Repository
public class UserDaoImpl implements UserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(User user) {

        String sql = "INSERT INTO user " +
                "(userId, userFirstName, userLastName,UserAge) VALUES (?, ?, ?,?)";
        Connection conn = null;

        try {
           conn = dataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUserFirstName());
            ps.setString(3, user.getUserLastName());
            ps.setInt(4,user.getUserAge());
            int flag=ps.executeUpdate();
            if(flag>0)
                System.out.println("Record Inserted....");
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int userId) {
        String sql = "delete FROM user where userId=?";
        Connection conn = null;

        try {

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            int flag=ps.executeUpdate();
            if(flag>0)
                System.out.println("Record Deleted....");
            ps.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser(int userId) {
        String sql = "SELECT * FROM user where userId=?";
        Connection conn = null;
        System.out.println("Where Dao Impl: "+userId);

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            ResultSet resultSet=  ps.executeQuery();
            User user=null;
           if(resultSet.next()){
                user =new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserFirstName(resultSet.getString("userFirstName"));
                user.setUserLastName(resultSet.getString("userLastName"));
                user.setUserAge(resultSet.getInt("userAge"));
               System.out.println(resultSet.getInt("userId")+
                       resultSet.getString("userFirstName")+
                       resultSet.getString("userAge")
               );

            }
            System.out.println("User Update List");
            ps.close();
            return user;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void editUser(User user) {
        String sql = "update user set userFirstName=?, userLastName=?, userAge=? where userId=?";
        Connection conn = null;

        try {

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserFirstName());
            ps.setString(2,user.getUserLastName());
            ps.setInt(3,user.getUserAge());
            ps.setInt(4,user.getUserId());
            System.out.println("SQL: "+sql);
            int flag=ps.executeUpdate();
            if(flag>0)
                System.out.println("Record Updated....");
            ps.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

    public List getUsers() {
        String sql = "SELECT * FROM user";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet=  ps.executeQuery();
            List userList = new ArrayList();
            while(resultSet.next()){
                User user =new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserFirstName(resultSet.getString("userFirstName"));
                user.setUserLastName(resultSet.getString("userLastName"));
                user.setUserAge(resultSet.getInt("userAge"));
                userList.add(user);
            }
            ps.close();
            return userList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

