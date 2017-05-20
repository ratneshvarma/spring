package com.spring.mvc;

import com.spring.mvc.model.Emp;
import com.spring.mvc.service.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView saveEmp(@ModelAttribute("emp") Emp emp, final  RedirectAttributes redirectAttributes ){
        empService.empInsert(emp);
        redirectAttributes.addFlashAttribute("message","Record Inserted.");
        return new ModelAndView("redirect:/emp/empList");

    }
    @RequestMapping(value = "/empList", method = RequestMethod.GET)
    public ModelAndView getData() {

        List empList= empService.getAllEmp();
        ModelAndView model = new ModelAndView("emp","emp",empList);
        model.addObject("empList",empList);
        return model;
    }

    @RequestMapping("/updateEmp")
    public ModelAndView updateEmp(@RequestParam("empId") int empId) {
        Emp emp= empService.getSpecificEmp(empId);
        return new ModelAndView("empUpdate","emp",emp);
    }

    @RequestMapping(value="/empUpdateSave")
    public ModelAndView saveUpdateEmp(@ModelAttribute("emp") Emp emp,final RedirectAttributes redirectAttribute){

       empService.empUpdate(emp);
        redirectAttribute.addFlashAttribute("message","Record Updated.");
        return new ModelAndView("redirect:/emp/empList");//will redirect to view emp request mapping
    }

    @RequestMapping(value="/deleteEmp")
    public ModelAndView deleteEmp(@RequestParam("empId") int empId,final RedirectAttributes redirectAttribute){

        empService.empDelete(empId);
        redirectAttribute.addFlashAttribute("message","Record Deleted.");
        return new ModelAndView("redirect:/emp/empList");//will redirect to view emp request mapping
    }
}
