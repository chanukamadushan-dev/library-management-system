package controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LogIn_Error_Controller {
    public Button btnRetry;

    public void btnRtryOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnRetry.getScene().getWindow();
        stage.close();
    }
}
