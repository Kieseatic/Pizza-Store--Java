package application.model;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class Order {
    private String pizzaSize; // Size of the pizza (e.g., small, medium, large, extra large)
    private String crustType; // Type of crust (e.g., thin, thick, stuffed)
    private List<String> toppings;  
    private Customer customer; // Reference to the customer who placed the order
    private double taxRate = 0.13; // Example tax rate of 13%
    @FXML
    private CheckBox cb_pineapple;
    @FXML
    private CheckBox cb_extraCheese;
    @FXML
    private CheckBox cb_driedShrimps;
    @FXML
    private CheckBox cb_mushrooms;
    @FXML
    private CheckBox cb_anchovies;
    @FXML
    private CheckBox cb_sunDriedTomatoes;
    @FXML
    private CheckBox cb_dacon;
    @FXML
    private CheckBox cb_spinach;
    @FXML
    private CheckBox cb_roastedGarlic;
    @FXML
    private CheckBox cb_jalapeno;

    @FXML
    private CheckBox cb_groundBeef;
    @FXML
    private CheckBox cb_shreddedChicken;
    @FXML
    private CheckBox cb_grilledChicken;
    @FXML
    private CheckBox cb_pepperoni;
    @FXML
    private CheckBox cb_ham;
    @FXML
    private CheckBox cb_bacon;

    // Default Constructor
    public Order() {
        this.pizzaSize = "";
        this.crustType = "";
        this.toppings = new ArrayList<>(); 
        this.customer = new Customer(); 
    }

    // Constructor
    public Order(String pizzaSize, String crustType, List<String> toppings, Customer customer) {
        this.pizzaSize = pizzaSize;
        this.crustType = crustType;
        this.toppings = toppings;
        this.customer = customer;
    }

    // Getters and Setters
    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double calculateTotalBeforeTax() {
        double basePrice = getBasePrice();
        double toppingsPrice = toppings.size() * 1.5; 
        return basePrice + toppingsPrice;
    }

    // Method to calculate total price after tax
    public double calculateTotalAfterTax() {
        double totalBeforeTax = calculateTotalBeforeTax();
        return totalBeforeTax * (1 + taxRate); 
    }

    
    
    // Method to calculate the price of the pizza base based on the size
    private double getBasePrice() {
        switch (pizzaSize.toLowerCase()) {
            case "small":
                return 7.00; 
            case "medium":
                return 10.00;
            case "large":
                return 13.00;
            case "extra large":
                return 15.00;
            default:
                return 0;
        }
    }

    // Method to calculate the total price of toppings
    private double calculateToppingsPrice() {
        double totalToppingPrice = 0.0;

        // Define prices for each topping (could be moved to a separate config or enum)
        for (String topping : toppings) {
            switch (topping.toLowerCase()) {
                case "pineapple":
                case "extra cheese":
                case "mushrooms":
                    totalToppingPrice += 1.10; // Price for veggie toppings
                    break;
                case "anchovies":
                case "bacon":
                case "ground beef":
                case "shredded chicken":
                case "pepperoni":
                    totalToppingPrice += 2.15; // Price for meat toppings
                    break;
               
            }
        }
        return totalToppingPrice;
    }
}

