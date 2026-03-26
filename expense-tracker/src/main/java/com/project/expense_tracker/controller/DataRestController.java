package com.project.expense_tracker.controller;

import com.project.expense_tracker.entity.DataSchema;
import com.project.expense_tracker.entity.SortSchema;
import com.project.expense_tracker.entity.UserSchema;
import com.project.expense_tracker.service.Dataservice;
import com.project.expense_tracker.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/data")
public class DataRestController {

    @Autowired
    Dataservice dataservice;
    @Autowired
    UserService userService;

    // return options to ad in select based on expense or income
    @PostMapping("/categorydata")
    public Map<String, String> setIncomeExpenseField(@RequestParam String selectedValue) {
        if (selectedValue.equalsIgnoreCase("income"))
            return dataservice.setIncomeCategories();
        else if (selectedValue.equalsIgnoreCase("expense"))
            return dataservice.setExpenseCategories();
        else
            return Map.of("error", "Invalid_Type");
    }

    // return data to FUll Data
    @PostMapping("/userdata")
    public List<DataSchema> sendData(HttpSession session) {
        UserSchema semiuserSchema = (UserSchema) session.getAttribute("loggedUser");
        UserSchema userSchema = userService.getFullSchema(semiuserSchema);
        return dataservice.fetchFullData(userSchema);
    }

    @PostMapping("/sort")
    public List<DataSchema> sortData(HttpSession session, @RequestBody SortSchema sortSchema) {
        UserSchema semiuserSchema = (UserSchema) session.getAttribute("loggedUser");
        UserSchema userSchema = userService.getFullSchema(semiuserSchema);
        List<DataSchema> sortedData = dataservice.getSortingData(sortSchema);
        System.out.println("User: " + userSchema.toString());
        System.out.println("Sorting details: " + sortedData);
        return sortedData;
    }

    // First QueryDSL query example
    // @PostMapping("/userdata-querydsl")
    // public List<DataSchema> sendDataQueryDSL(HttpSession session) {
    //     UserSchema semiuserSchema = (UserSchema) session.getAttribute("loggedUser");
    //     UserSchema userSchema = userService.getFullSchema(semiuserSchema);
    //     return dataservice.getDataSchemaByUserQueryDSL(userSchema);
    // }
}
