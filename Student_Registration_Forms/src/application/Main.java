package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Creating form elements
            Label nameLabel = new Label("Name:");
            TextField nameTextField = new TextField();

            Label idLabel = new Label("ID:");
            TextField idTextField = new TextField();

            Label emailLabel = new Label("Email:");
            TextField emailTextField = new TextField();

            Label genderLabel = new Label("Gender:");
            ToggleGroup genderToggleGroup = new ToggleGroup();
            RadioButton maleRadioButton = new RadioButton("Male");
            maleRadioButton.setToggleGroup(genderToggleGroup);
            RadioButton femaleRadioButton = new RadioButton("Female");
            femaleRadioButton.setToggleGroup(genderToggleGroup);

            Label termsLabel = new Label("Agree to terms and conditions:");
            CheckBox termsCheckBox = new CheckBox();

            // Creating TableView to display student data
            TableView<Student> tableView = new TableView<>();
            TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            TableColumn<Student, String> idColumn = new TableColumn<>("ID");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            tableView.getColumns().addAll(nameColumn, idColumn, emailColumn);

            // Adding form elements to VBox
            VBox formVBox = new VBox(10);
            formVBox.getChildren().addAll(
                    nameLabel, nameTextField,
                    idLabel, idTextField,
                    emailLabel, emailTextField,
                    genderLabel, maleRadioButton, femaleRadioButton,
                    termsLabel, termsCheckBox
            );

            // Creating Submit button
            Button submitButton = new Button("Submit");
            submitButton.setOnAction(event -> {
                try {
                    // Retrieve data from form
                    String name = nameTextField.getText();
                    String id = idTextField.getText();
                    String email = emailTextField.getText();
                    String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                    boolean agreedToTerms = termsCheckBox.isSelected();

                    // Add data to TableView
                    tableView.getItems().add(new Student(name, id, email, gender, agreedToTerms));

                    // Clear form fields
                    nameTextField.clear();
                    idTextField.clear();
                    emailTextField.clear();
                    maleRadioButton.setSelected(false);
                    femaleRadioButton.setSelected(false);
                    termsCheckBox.setSelected(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // Creating BorderPane to organize layout
            BorderPane root = new BorderPane();
            root.setLeft(formVBox);
            root.setBottom(submitButton);
            root.setCenter(tableView);

            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Student Registration Form");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public static void main(String[] args) {
        launch(args);
    }
}
