package com.project.expense_tracker.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
public class SortSchema {
    String name;
    Double amount;
    String amountType; //same,greater,smaller
    Date finaldate;
    String datetype; //on,before,after
    String typeslt; //income,expense
    String paymentMethod; //paymentmethod

    public String toString(){
        return "Name: "+name+" Amount: "+amount+" AmountType: "+amountType+" Date: "+finaldate+" DateType: "+datetype+" Type: "+typeslt+" Method: "+paymentMethod;
    }

}
