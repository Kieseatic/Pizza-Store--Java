package application.model;

public class Customer {
    private String customerName;
    private String customerPhone;

    // Default constructor
    public Customer() {
        this.customerName = "";
        this.customerPhone = "";

    }

    // Parameterized constructor
    public Customer(String customerName, String customerPhone) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }
    
    // Getters and Setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
  
    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +'}';
    }
}
