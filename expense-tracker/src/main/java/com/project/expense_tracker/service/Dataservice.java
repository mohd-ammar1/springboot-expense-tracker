package com.project.expense_tracker.service;

import com.project.expense_tracker.entity.DataSchema;
import com.project.expense_tracker.entity.UserSchema;
import com.project.expense_tracker.repositry.DataRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public Map<String,String> setIncomeCategories(){
                Map<String, String> incomeCategories = Map.ofEntries(
                        Map.entry("salary", "Salary"),
                        Map.entry("businessIncome", "Business Income"),
                        Map.entry("freelancing", "Freelancing"),
                        Map.entry("bonus", "Bonus"),
                        Map.entry("commission", "Commission"),
                        Map.entry("tips", "Tips"),
                        Map.entry("rentalIncome", "Rental Income"),
                        Map.entry("interest", "Interest"),
                        Map.entry("dividends", "Dividends"),
                        Map.entry("investmentGains", "Investment Gains"),
                        Map.entry("sideHustle", "Side Hustle"),
                        Map.entry("giftsReceived", "Gifts Received"),
                        Map.entry("refundCashback", "Refund / Cashback"),
                        Map.entry("otherIncome", "Other Income"),
                        // Extra categories
                        Map.entry("royalties", "Royalties"),
                        Map.entry("grant", "Grant"),
                        Map.entry("scholarship", "Scholarship"),
                        Map.entry("lotteryWinnings", "Lottery Winnings"),
                        Map.entry("alimony", "Alimony"),
                        Map.entry("pension", "Pension")
                );

        return incomeCategories;
    }

    public Map<String,String> setExpenseCategories(){
        Map<String, String> EXPENSE_CATEGORIES = Map.ofEntries(
                Map.entry("rentMortgage", "Rent / Mortgage"),
                Map.entry("utilities", "Utilities"),
                Map.entry("maintenanceRepairs", "Maintenance / Repairs"),
                Map.entry("groceries", "Groceries"),
                Map.entry("diningOut", "Dining Out"),
                Map.entry("foodDelivery", "Food Delivery"),
                Map.entry("fuel", "Fuel"),
                Map.entry("publicTransport", "Public Transport"),
                Map.entry("taxiCab", "Taxi / Cab"),
                Map.entry("vehicleMaintenance", "Vehicle Maintenance"),
                Map.entry("medicalExpenses", "Medical Expenses"),
                Map.entry("medicines", "Medicines"),
                Map.entry("healthInsurance", "Health Insurance"),
                Map.entry("gymFitness", "Gym / Fitness"),
                Map.entry("clothing", "Clothing"),
                Map.entry("personalCare", "Personal Care"),
                Map.entry("educationCourses", "Education / Courses"),
                Map.entry("books", "Books"),
                Map.entry("officeSupplies", "Office Supplies"),
                Map.entry("softwareSubscriptions", "Software / Subscriptions"),
                Map.entry("entertainment", "Entertainment"),
                Map.entry("travelVacation", "Travel / Vacation"),
                Map.entry("hobbies", "Hobbies"),
                Map.entry("loanEmi", "Loan EMI"),
                Map.entry("creditCardPayment", "Credit Card Payment"),
                Map.entry("tax", "Tax"),
                Map.entry("giftsGiven", "Gifts"),
                Map.entry("donations", "Donations"),
                Map.entry("miscellaneous", "Miscellaneous")
        );
        return EXPENSE_CATEGORIES;
    }





}
