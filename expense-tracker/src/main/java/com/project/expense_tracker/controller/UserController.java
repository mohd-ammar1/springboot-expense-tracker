package com.project.expense_tracker.controller;

import com.project.expense_tracker.entity.UserSchema;
import com.project.expense_tracker.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller()
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("signup",new UserSchema());
        return("signUp");
    }

    @PostMapping("/signup")
    public String processSignUp(@ModelAttribute("signup") UserSchema userSchema, HttpSession session){
        userService.signup(userSchema);
        session.setAttribute("loggedUser",userSchema);
        return("redirect:/home");
    }
    @GetMapping("/login")
    public String signIn(Model model){
        model.addAttribute("login", new UserSchema());
        return("login");
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("login") UserSchema userSchema,HttpSession session){
        if (userService.signIn(userSchema)){
            session.setAttribute("loggedUser", userSchema);
            return("redirect:/home");
        }else{
            return("redirect:/signup");
        }
    }
}
