package com.spring.mvc;

import com.spring.mvc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by ratnesh on 8/5/17.
 */

@Controller
public class HelloController {
    @Autowired
    Employee employee;
    @Autowired
    HttpSession httpSession;
    @RequestMapping("/index")
    public String index(ModelMap model) {

        employee.setFirstName("Ratnesh");
        employee.setLastName("Varma");
        List list= new ArrayList();
        list.add("India");
        list.add("Bharat");
        employee.setCountry(list);

        Map mapList = new HashMap<String, Object>();
        mapList.put("ratnesh","Ratnesh");
        mapList.put("varma","Varma");
        mapList.put("gurgaon","Gurugram");
        employee.setUserList(mapList);
        System.out.println("LIst: "+ employee.getCountry());
        System.out.println("MapLIst: "+ employee.getUserList());

        model.addAttribute("employee",employee);
        httpSession.setAttribute("sessionViaHttpSession",employee);


        return "index";
    }
}
