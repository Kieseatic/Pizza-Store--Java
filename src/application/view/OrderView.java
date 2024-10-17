package application.view;

import application.model.Customer;
import application.model.Order;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class OrderView {

    @FXML
    private SplitPane box_size;

    @FXML
    private SplitPane crustType;

    @FXML
    private RadioButton rb_small;

    @FXML
    private RadioButton rb_medium;

    @FXML
    private RadioButton rb_large;

    @FXML
    private RadioButton rb_extraLarge;

    @FXML
    private RadioButton rb_normal;

    @FXML
    private RadioButton rb_thin;

    @FXML
    private RadioButton rb_deepDish;
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

    @FXML
    private Button btnOrder; 

    @FXML
    private Label lblOrderSummary; 

    private Customer customer; 
    
    public void initialize() {

        ToggleGroup sizeGroup = new ToggleGroup();
        rb_small.setToggleGroup(sizeGroup);
        rb_medium.setToggleGroup(sizeGroup);
        rb_large.setToggleGroup(sizeGroup);
        rb_extraLarge.setToggleGroup(sizeGroup);

        ToggleGroup crustGroup = new ToggleGroup();
        rb_normal.setToggleGroup(crustGroup);
        rb_thin.setToggleGroup(crustGroup);
        rb_deepDish.setToggleGroup(crustGroup);

        // Set up the button click handler
        //btnOrder.setOnAction(event -> placeOrder());
    }
    

    // Setter for Customer (optional, if you want to pass a customer object from outside)
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
