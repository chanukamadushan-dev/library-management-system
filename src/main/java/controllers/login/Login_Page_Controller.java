package controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scene.SceneManager;

import java.io.IOException;

public class Login_Page_Controller {
    LogInController logInController = new LogInController();
    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnReset;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void txtUserNameOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        btnLogInOnAction(event);
    }

    @FXML
    void btnLogInOnAction(ActionEvent event) {
        if (logInController.checkUserNameAndPasswor(txtUserName.getText(),txtPassword.getText())) {
            SceneManager.switchPgae("/view/main_dashboard.fxml");
        }else {
            SceneManager.switchPgae("/view/login/login_error.fxml");
            System.out.println("Login faild");
        }
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        txtUserName.setText("");
        txtPassword.setText("");
    }


}
