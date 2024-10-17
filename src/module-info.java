module Pizza {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens application.controller to javafx.graphics, javafx.fxml;
    exports application; // Export the application package if necessary

}
