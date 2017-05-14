package com.spring.mvc;

import com.spring.mvc.model.User;
import com.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by ratnesh on 13/5/17.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    User user;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView getdata() {
        user.setUserFirstName("Ratnesh");
        user.setUserLastName("Varma");
        user.setUserId(204);
        user.setUserAge(28);
//        userService.insertUser();
        List userList= userService.allUsers();
        ModelAndView model = new ModelAndView("user","user",user);
        model.addObject("userList",userList);
        return model;
    }
    @RequestMapping("/newUser")
    public ModelAndView addUserPage() {
        return new ModelAndView("add","user",new User());
//        return new ModelAndView("add",modelName:"command",new User());
//        model command by default call user model on jsp add.jsp
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") User user){

        userService.insertUser(user);
        return new ModelAndView("redirect:/user/userList");//will redirect to view user request mapping
    }

 @RequestMapping("/deleteUser")
 public String deleteUser(@RequestParam("userId") int userId, final RedirectAttributes redirectAttributes){
     userService.userDelete(userId);
     // modelAndView.addObject();
     redirectAttributes.addFlashAttribute("success","Successfully deleted");
     return "redirect:/user/userList";
 }
    @RequestMapping("/updateUser")
    public ModelAndView updateUser(@RequestParam("userId") int userId) {
     User user= userService.specificUser(userId);
        System.out.println("USER ID: "+userId+ user.getUserFirstName());
        return new ModelAndView("update","user",user);
    }

    @RequestMapping(value="/editUser")
    public ModelAndView saveUpdateUser(@ModelAttribute("user") User user){

        userService.updateSpecificUser(user);
        System.out.println("Controller for update"+user.getUserId()+ user.getUserFirstName());
        return new ModelAndView("redirect:/user/userList");//will redirect to view user request mapping
    }

    @RequestMapping("/session-check")
    public String sessionTest(){
        return "session";
    }
}
