package com.project.expense_tracker.controller;

import com.project.expense_tracker.entity.UserSchema;
import com.project.expense_tracker.repositry.UserRepositry;
import com.project.expense_tracker.service.Dataservice;
import com.project.expense_tracker.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.expense_tracker.entity.DataSchema;

import java.util.List;


@Controller
public class Webcontroller {

    @Autowired
    Dataservice dataservice;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("dataSchema", new DataSchema());
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("dataSchema", new DataSchema());
        return "home";
    }

    @PostMapping("/submit" ) 
    public String submitData(@ModelAttribute("dataSchema") DataSchema entity, HttpSession session) {
        UserSchema semiuserSchema = (UserSchema) session.getAttribute("loggedUser");
        UserSchema userSchema = userService.getFullSchema(semiuserSchema);
        entity.setUserSchema(userSchema);
        dataservice.saveData(entity);
        return("success");
    }

    @GetMapping("/data")
    public String showUsers(Model model , HttpSession session){
        UserSchema semiuserSchema = (UserSchema) session.getAttribute("loggedUser");
        UserSchema userSchema = userService.getFullSchema(semiuserSchema);
        List<DataSchema> fullData = dataservice.fetchFullData(userSchema);
        model.addAttribute("transactions",fullData);
        return "fullData";
    }


    
}
