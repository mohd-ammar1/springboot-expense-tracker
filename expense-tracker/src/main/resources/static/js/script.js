const incomeCategories = [
  { value: "salary", text: "Salary" },
  { value: "businessIncome", text: "Business Income" },
  { value: "freelancing", text: "Freelancing" },
  { value: "bonus", text: "Bonus" },
  { value: "commission", text: "Commission" },
  { value: "tips", text: "Tips" },
  { value: "rentalIncome", text: "Rental Income" },
  { value: "interest", text: "Interest" },
  { value: "dividends", text: "Dividends" },
  { value: "investmentGains", text: "Investment Gains" },
  { value: "sideHustle", text: "Side Hustle" },
  { value: "giftsReceived", text: "Gifts Received" },
  { value: "refundCashback", text: "Refund / Cashback" },
  { value: "otherIncome", text: "Other Income" }
];

const expenseCategories = [
  // Housing
  { value: "rentMortgage", text: "Rent / Mortgage" },
  { value: "utilities", text: "Utilities" },
  { value: "maintenanceRepairs", text: "Maintenance / Repairs" },

  // Food
  { value: "groceries", text: "Groceries" },
  { value: "diningOut", text: "Dining Out" },
  { value: "foodDelivery", text: "Food Delivery" },

  // Transportation
  { value: "fuel", text: "Fuel" },
  { value: "publicTransport", text: "Public Transport" },
  { value: "taxiCab", text: "Taxi / Cab" },
  { value: "vehicleMaintenance", text: "Vehicle Maintenance" },

  // Health
  { value: "medicalExpenses", text: "Medical Expenses" },
  { value: "medicines", text: "Medicines" },
  { value: "healthInsurance", text: "Health Insurance" },
  { value: "gymFitness", text: "Gym / Fitness" },

  // Shopping & Personal
  { value: "clothing", text: "Clothing" },
  { value: "personalCare", text: "Personal Care" },

  // Education & Work
  { value: "educationCourses", text: "Education / Courses" },
  { value: "books", text: "Books" },
  { value: "officeSupplies", text: "Office Supplies" },
  { value: "softwareSubscriptions", text: "Software / Subscriptions" },

  // Lifestyle
  { value: "entertainment", text: "Entertainment" },
  { value: "travelVacation", text: "Travel / Vacation" },
  { value: "hobbies", text: "Hobbies" },

  // Finance
  { value: "loanEmi", text: "Loan EMI" },
  { value: "creditCardPayment", text: "Credit Card Payment" },
  { value: "tax", text: "Tax" },

  // Misc
  { value: "giftsGiven", text: "Gifts" },
  { value: "donations", text: "Donations" },
  { value: "miscellaneous", text: "Miscellaneous" }
];
console.log("Javascript Loaded");

function typeChanged() {
    const type = document.getElementById("type").value;
    const categorySelect = document.getElementById("category");
    categorySelect.innerHTML = '<option value="">Select</option>';
    if (type === "income") {
        incomeCategories.forEach(cat => {
            categorySelect.add(new Option(cat.text, cat.value));
        });
    }
    else if (type === "expense") {
        expenseCategories.forEach(cat => {
            categorySelect.add(new Option(cat.text, cat.value));
        });
    }
}

let dataDoor = document.getElementById("dataDoor");
dataDoor.onclick(function () {
    window.location.href="http://localhost:8080/data";
})
