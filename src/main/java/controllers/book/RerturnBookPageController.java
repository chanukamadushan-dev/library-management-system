package controllers.book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.Issue;
import scene.SceneManager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RerturnBookPageController implements Initializable {

    ReturnBookController controller = new ReturnBookController();


    @FXML
    private Button btnReturn;

    @FXML
    private Button btnSearch;

    @FXML
    private ComboBox<Issue> cmbSearchbyBook;

    @FXML
    private Label lblBorrowedDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblMemberID;

    @FXML
    private Label lblMemberName;

    @FXML
    void btnReturnOnAction(ActionEvent event) {

        Issue selectedIssue = cmbSearchbyBook.getValue();

        int borrowId = selectedIssue.getBorrowId();
        LocalDate returnDate = LocalDate.now();

        controller.setDate(
                borrowId,
                returnDate
        );
        clearFields();
       cmbSearchbyBook.setItems(controller.getBorrowData());
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        selectBook();
    }

    @FXML
    void cmbSearchbyBookOnAction(ActionEvent event) {


    }

    private void clearFields() {

        cmbSearchbyBook.setValue(null);

        lblMemberID.setText("");
        lblMemberName.setText("");
        lblBorrowedDate.setText("");
        lblDueDate.setText("");
    }


    @FXML
    private void selectBook() {

        Issue selcetedIssue = cmbSearchbyBook.getValue();

        if (selcetedIssue == null) {
            return;
        }
        lblMemberID.setText(selcetedIssue.getMemberId());
        lblMemberName.setText(selcetedIssue.getMemberName());
        lblBorrowedDate.setText(String.valueOf(selcetedIssue.getIssueDate()));
        lblDueDate.setText(String.valueOf((selcetedIssue.getDueDate())));


    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {

        SceneManager.switchPgae("/view/main_dashboard.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cmbSearchbyBook.setItems(controller.getBorrowData());
    }
}
