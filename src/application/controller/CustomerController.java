package application.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.model.Customer;
import application.model.Order;
import application.view.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class CustomerController {
	
	private OrderView orderV;

    @FXML
    private GridPane customerPane;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private RadioButton rb_small, rb_medium, rb_large, rb_extraLarge;
    @FXML
    private RadioButton rb_normal, rb_thin, rb_deepDish;

    @FXML
    private CheckBox cb_pineapple, cb_extraCheese, cb_driedShrimps, cb_mushrooms, cb_anchovies, cb_sunDriedTomatoes, cb_bacon, cb_spinach, cb_roastedGarlic, cb_jalapeno;
    @FXML
    private CheckBox cb_groundBeef, cb_shreddedChicken, cb_grilledChicken, cb_pepperoni, cb_ham;

    @FXML
    private Label pizzaTypeLabel, crustTypeLabel;

    @FXML
    private TextArea toppingsLabel;

    @FXML
    private Button placeOrder, clearButton, orderConfirmationButton;

    private Customer customer;
    private Order order;

    @FXML
    private ToggleGroup pizzaSizeToggle, crustTypeToggle;
    
    private CustomerView cView;
    
    @FXML
    private List<CheckBox> toppingCheckBoxes;

    @FXML
    public void initialize() {
        customer = new Customer();
        order = new Order();

        // Initialize topping checkboxes
        toppingCheckBoxes = Arrays.asList(cb_pineapple, cb_extraCheese, cb_driedShrimps, cb_mushrooms, cb_anchovies,
                cb_sunDriedTomatoes, cb_bacon, cb_spinach, cb_roastedGarlic, cb_jalapeno, cb_groundBeef, cb_shreddedChicken,
                cb_grilledChicken, cb_pepperoni, cb_ham);

        // Set action handlers
        placeOrder.setOnAction(event -> handleSave());
        orderConfirmationButton.setOnAction(event -> showOrderSummary());
        clearButton.setOnAction(event -> clearAll());
    }

    public void setCustomer(Customer customer) {
    	this.customer = customer;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public void setCView(CustomerView cView) {
    	this.cView = cView;
    	
    }
    public void setGridPane(GridPane gridPane) {
        this.customerPane = gridPane;
    }
    // Clear all input fields and reset selections
    @FXML
    public void clearAll() {
        nameField.clear();
        phoneField.clear();
        pizzaSizeToggle.selectToggle(null);
        crustTypeToggle.selectToggle(null);

        for (CheckBox checkbox : toppingCheckBoxes) {
            checkbox.setSelected(false);
        }

        pizzaTypeLabel.setText("");
        crustTypeLabel.setText("");
        toppingsLabel.setText("");
    }

    // Display order summary in a new window
    @FXML
    public void showOrderSummary() {
        String name = cView.getCustomerName();
        String phone = phoneField.getText();
        String pizzaSize = getSelectedPizzaSize();
        String crustType = getSelectedCrustType();
        List<String> selectedToppings = getSelectedToppings();

        order.setPizzaSize(pizzaSize);
        order.setCrustType(crustType);
        order.setToppings(selectedToppings);

        double totalBeforeTax = order.calculateTotalBeforeTax();
        double totalAfterTax = order.calculateTotalAfterTax();

        StringBuilder orderSummary = new StringBuilder();
        orderSummary.append("Customer Name: ").append(name).append("\n");
        orderSummary.append("Customer Phone: ").append(phone).append("\n");
        orderSummary.append("Pizza Size: ").append(pizzaSize).append("\n");
        orderSummary.append("Crust Type: ").append(crustType).append("\n");
        orderSummary.append("Toppings: ").append(String.join(", ", selectedToppings)).append("\n");
        orderSummary.append("Total before tax: $").append(String.format("%.2f", totalBeforeTax)).append("\n");
        orderSummary.append("Total Cost: $").append(String.format("%.2f", totalAfterTax)).append("\n");

        // Display the order summary in a new window
        Stage orderSummaryStage = new Stage();
        orderSummaryStage.setTitle("Order Summary");

        TextArea orderSummaryTextArea = new TextArea(orderSummary.toString());
        orderSummaryTextArea.setEditable(false);
        orderSummaryTextArea.setWrapText(true);

        Label titleLabel = new Label("Order Summary");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> orderSummaryStage.close());

        VBox vbox = new VBox(titleLabel, orderSummaryTextArea, closeButton);
        Scene scene = new Scene(vbox, 500, 500);
        orderSummaryStage.setScene(scene);
        orderSummaryStage.show();
    }

    // Handle saving customer order details and displaying it in the UI
    @FXML
    public void handleSave() {
        String pizzaSize = getSelectedPizzaSize();
        String crustType = getSelectedCrustType();
        List<String> selectedToppings = getSelectedToppings();

        pizzaTypeLabel.setText(pizzaSize);
        crustTypeLabel.setText(crustType);
        toppingsLabel.setText(String.join("\n", selectedToppings));
    }

    // Retrieve selected pizza size
    private String getSelectedPizzaSize() {
        if (rb_small.isSelected()) {
            return "Small";
        } else if (rb_medium.isSelected()) {
            return "Medium";
        } else if (rb_large.isSelected()) {
            return "Large";
        } else if (rb_extraLarge.isSelected()) {
            return "Extra Large";
        }
        return "None";
    }


    // Retrieve selected crust type
    private String getSelectedCrustType() {
        if (rb_normal.isSelected()) {
            return "Normal";
        } else if (rb_thin.isSelected()) {
            return "Thin";
        } else if (rb_deepDish.isSelected()) {
            return "Deep Dish";
        }
        return "None";
    }

    // Retrieve selected toppings
    private List<String> getSelectedToppings() {
        List<String> toppings = new ArrayList<>();

        for (CheckBox checkbox : toppingCheckBoxes) {
            if (checkbox.isSelected()) {
                toppings.add(checkbox.getText());
            }
        }
        return toppings;
    }

}
