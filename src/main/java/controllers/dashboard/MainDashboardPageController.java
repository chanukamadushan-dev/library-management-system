package controllers.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import scene.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

public class MainDashboardPageController implements Initializable {

    private final MainDashboardController dashboardController = new MainDashboardController();

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

        SceneManager.switchPgae("/view/borrowing_history_page.fxml");
    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {

        SceneManager.switchPgae("/view/issue_booK_page.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

        SceneManager.switchPgae("/view/login/login_page.fxml");
    }

    @FXML
    void btnManageMembersOnAction(ActionEvent event) {

        SceneManager.switchPgae("/view/manage_members_page.fxml");
    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {

        SceneManager.switchPgae("/view/return_book_page.fxml");
    }

    @FXML
    void btnSignInOnAction(ActionEvent event) {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        int bookQty = dashboardController.getBookCount();
        int memberQty = dashboardController.getMemberCount();
        int borrowedBookCount = dashboardController.getBorrowedBookCount();
        int overdueBookCount = dashboardController.getOverdueBookCount();

        lblTotalBookCount.setText(String.valueOf(bookQty));
        lblTotalMemberCount.setText(String.valueOf(memberQty));
        lblBorrowedBookCount.setText(String.valueOf(borrowedBookCount));
        lblOverDueCount.setText(String.valueOf(overdueBookCount));

    }
}
