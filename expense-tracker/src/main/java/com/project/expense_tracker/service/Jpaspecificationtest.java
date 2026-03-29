package com.project.expense_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.project.expense_tracker.entity.DataSchema;

@Service
public class Jpaspecificationtest {
    
    public static Specification<DataSchema> getFromname(String name){
        if (!name.isEmpty() || name.equals(null)|| name.equals("")) {
            return null;
        }
        return(root,query,cb)->{
            return cb.like(root.get("name"),"%"+name+"%");//dont know what to do here
        };
    }
}
