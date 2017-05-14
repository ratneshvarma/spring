package com.spring.mvc.service;

import com.spring.mvc.dao.UserDao;
import com.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ratnesh on 14/5/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public void insertUser(User user) {
        userDao.insert(user);
    }

    public void userDelete(int userId) {
        userDao.deleteUser(userId);
    }

    public User specificUser(int userId) {
        return userDao.getUser(userId);
    }

    public void updateSpecificUser(User user) {
        userDao.editUser(user);
    }

    public List allUsers() {
        return userDao.getUsers();
    }
}
