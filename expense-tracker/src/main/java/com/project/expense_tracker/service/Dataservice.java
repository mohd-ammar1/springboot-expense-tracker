package com.project.expense_tracker.service;

import com.project.expense_tracker.entity.DataSchema;
import com.project.expense_tracker.entity.UserSchema;
import com.project.expense_tracker.repositry.DataRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Dataservice {

    @Autowired
    public DataRepositry dataRepositry;

    public DataSchema saveData(DataSchema dataSchema){
        return dataRepositry.save(dataSchema);
    }

    public List<DataSchema> allData(){
        return dataRepositry.findAll();
    }

    public DataSchema updatebyId(int id,DataSchema dataSchema){

        DataSchema findRes = dataRepositry.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
        findRes.setAmount(dataSchema.getAmount());
        findRes.setCategory(dataSchema.getCategory());
        findRes.setDate(dataSchema.getDate());
        findRes.setName(dataSchema.getName());
        findRes.setPaymentMethod(dataSchema.getPaymentMethod());
        findRes.setType(dataSchema.getType());
        findRes.setCategory(dataSchema.getCategory());
        findRes.setNote(dataSchema.getNote());
        return findRes;
    }

    public List<DataSchema> fetchFullData( UserSchema userSchema) {
        return dataRepositry.findByUserSchema(userSchema);
    }
}
