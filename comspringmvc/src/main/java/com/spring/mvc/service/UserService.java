package com.spring.mvc.service;

import com.spring.mvc.dao.UserDaoImpl;
import com.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ratnesh on 14/5/17.
 */

public interface UserService {
   void insertUser(User user);
   void userDelete(int userId);
   User specificUser(int userId);
   void updateSpecificUser(User user);
   List allUsers();
}
