package com.spring.mvc;

import com.spring.mvc.model.Emp;
import com.spring.mvc.service.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ratnesh on 14/5/17.
 */
@Controller
@RequestMapping("/emp")
@SessionAttributes("user")
public class EmpController {
    @Autowired
    EmpServiceImpl empService;

    @RequestMapping("/newEmp")
    public ModelAndView newEmp(){
       return new ModelAndView("addEmp","emp",new Emp());
    }
    @RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
    public ModelAndView sameEmp(@ModelAttribute("emp") Emp emp){
        empService.empInsert(emp);
        return new ModelAndView("redirect:/emp/empList");

    }
    @RequestMapping(value = "/empList", method = RequestMethod.GET)
    public ModelAndView getData() {

        List empList= empService.getAllEmp();
        ModelAndView model = new ModelAndView("emp","emp",empList);
        model.addObject("empList",empList);
        return model;
    }

}
