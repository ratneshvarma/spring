package com.spring.mvc.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 8/5/17.
 */

@Component
public class Employee {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;
    private String lastName;
    private List country;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List getCountry() {
        return country;
    }

    public void setCountry(List country) {
        this.country = country;
    }

    private Map userList;

    public Map getUserList() {
        return userList;
    }

    public void setUserList(Map userList) {
        this.userList = userList;
    }
}
