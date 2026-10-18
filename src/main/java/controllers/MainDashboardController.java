package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import scene.SceneManager;

public class MainDashboardController {

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnBorrowHistory;

    @FXML
    private Button btnIssueBook;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnManageMembers;

    @FXML
    private Button btnReturnBook;

    @FXML
    private Button btnSignIn;

    @FXML
    private TableColumn<?, ?> colmBookName;

    @FXML
    private TableColumn<?, ?> colmBorrowDt;

    @FXML
    private TableColumn<?, ?> colmCustomerName;

    @FXML
    private TableColumn<?, ?> colmDueDt;

    @FXML
    private Label lblBorrowedBookCount;

    @FXML
    private Label lblOverDueCount;

    @FXML
    private Label lblTotalBookCount;

    @FXML
    private Label lblTotalMemberCount;

    @FXML
    private TableView<?> tblDashboard;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {

        SceneManager.switchPgae("/view/adding/add_books_page.fxml");
    }

    @FXML
    void btnBorrowHistoryOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

    }

    @FXML
    void btnManageMembersOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnSignInOnAction(ActionEvent event) {

    }

}
