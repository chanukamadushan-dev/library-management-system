package controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            Stage stage = (Stage) btnLogIn.getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login/login_error.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
            System.out.println("Login faild");
        }
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        txtUserName.setText("");
        txtPassword.setText("");
    }


}
