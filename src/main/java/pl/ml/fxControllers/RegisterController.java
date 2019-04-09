package pl.ml.fxControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.ml.UserController.UserController;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Remigiusz Zudzin
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField userNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button applyButton;
    @FXML
    private Button cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setApplyButton() {

        if(firstNameField.getText().equals("") ||
            lastNameField.getText().equals("") ||
            userNameField.getText().equals("") ||
            passwordField.getText().equals("")
            ) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd rejestracji!");
            alert.setHeaderText("Naprawdę, puste pola?");
            alert.showAndWait();

        } else if (!UserController.checkIfPasswordMatchesPattern(passwordField.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd rejestracji!");
            alert.setHeaderText("Password has to be between 8 and 40 characters long\n" +
                    "Contain at least one digit.\n" +
                    "Contain at least one lower case character.\n" +
                    "Contain at least one upper case character.\n" +
                    "Contain at least on special character from [ @ # $ % ! . ].");
            alert.showAndWait();
        } else {
            if (UserController.checkIfLoginExists(userNameField.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Bląd rejestracji!");
                alert.setHeaderText("Podany login istnieje!");
                alert.showAndWait();
            } else {
                UserController.registerUser(firstNameField.getText(),
                        lastNameField.getText(),
                        userNameField.getText(),
                        passwordField.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User created!");
                alert.setHeaderText("Created!");
                alert.showAndWait();
                Stage stage = (Stage) applyButton.getScene().getWindow();
                stage.close();
            }
        }

    }

    public void setCancelButton() {
        Stage stage =(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
