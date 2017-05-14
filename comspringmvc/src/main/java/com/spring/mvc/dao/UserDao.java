package com.spring.mvc.dao;

import com.spring.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ratnesh on 14/5/17.
 */

public interface UserDao {
    void insert(User user);
    void deleteUser(int userId);
    User getUser(int userId);
    void editUser(User user);
    List getUsers();
}
