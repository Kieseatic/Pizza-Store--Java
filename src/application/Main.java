/**********************************************
Workshop 2
Course: APD545 - Semester 5
Last Name:Dugar
First Name: Harsh
ID:112689229
Section: ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Harsh Dugar
Date:06-10-2024
**********************************************/


package application;

import application.controller.CustomerController;
import application.model.Customer;
import application.model.Order; // Import the Order class
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pizzaDel.fxml")); 
        Parent root = loader.load();

        CustomerController customerController = loader.getController();

        Order order = new Order();

        customerController.setOrder(order);

        //GridPane gridPane = (GridPane) root.lookup("#customerPane"); 

        // Set the GridPane in the controller
        //customerController.setGridPane(gridPane);

        // Set up the scene and stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Customer Management System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
