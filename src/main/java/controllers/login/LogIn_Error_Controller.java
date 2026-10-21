package controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import scene.SceneManager;

import java.io.IOException;

public class LogIn_Error_Controller {
    public Button btnRetry;

    public void btnRtryOnAction(ActionEvent actionEvent) {
        SceneManager.switchPgae("/view/main_dashboard.fxml");
    }
}
