package application.view;

import application.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CustomerView {

    @FXML
    private TextField tf_nameField; // Corresponds to your FXML id
    @FXML
    private TextField tf_phoneField; // Corresponds to your FXML id
    @FXML
    private Button saveButton; // Save Button
    @FXML
    private GridPane customerPane; // GridPane for layout

    private Customer customer;

    public CustomerView(Customer customer) {
        this.customer = customer;
    }

    @FXML
    public void initialize() {
        // Initialize text fields with customer info
        tf_nameField.setText(customer.getCustomerName());
        tf_phoneField.setText(customer.getCustomerPhone());

        // Set up the save button action
        saveButton.setOnAction(e -> saveCustomerData());
    }

    // Save the customer data when the button is clicked
    private void saveCustomerData() {
        customer.setCustomerName(getCustomerName());
        customer.setCustomerPhone(getPhoneNumber());

        System.out.println("Customer Information Saved: " + customer);
    }

    // Methods to access customer information from the view
    public String getCustomerName() {
        return tf_nameField.getText();
    }

    public String getPhoneNumber() {
        return tf_phoneField.getText();
    }
}
