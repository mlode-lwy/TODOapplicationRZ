package pl.ml.fxControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Data;
import pl.ml.UserController.UserController;
import pl.ml.UserController.Users;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Remigiusz Zudzin
 */

@Data
public class LogScreenController implements Initializable {

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button logInButton;

    @FXML
    private Button registerButton;

    RegisterController registerController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setLogInButton() throws IOException {
        Users user = UserController.login(userNameField.getText(), passwordField.getText());
        if (user == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Logowanie nieudane!");
            alert.setHeaderText(null);
            alert.setContentText("Błędny login lub hasło!");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/tasks.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            TaskSceneController taskSceneController = loader.getController();
            taskSceneController.setUser(user);
            taskSceneController.loadTasks();
            Stage stage = (Stage) logInButton.getScene().getWindow();
            stage.close();
            Stage taskStage = new Stage();
            taskStage.setScene(new Scene(root));
            taskStage.show();
        }
    }

    public void setRegistryButton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/register.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        RegisterController registerController = loader.getController();
        Stage registryStage = new Stage();
        registryStage.setScene(new Scene(root));
        registryStage.show();
    }
}
