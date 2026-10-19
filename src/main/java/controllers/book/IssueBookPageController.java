package controllers.book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class IssueBookPageController implements Initializable {

    IssueBookController controller = new IssueBookController();

    @FXML
    private Button btnIssueBook;

    @FXML
    private ComboBox<Books> cmbSelectBook;

    @FXML
    private ComboBox<Members> cmbSelectMember;

    @FXML
    public DatePicker dpIssueDate;

    @FXML
    public DatePicker dpDueDate;

    @FXML
    private void issueBook(){

    }


    @FXML
    void cmbSelectBookOnAction(ActionEvent event) {

    }

    @FXML
    void cmbSelectMemberOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {

        Books selectedBook = cmbSelectBook.getValue();
        Members selectedMember = cmbSelectMember.getValue();

        LocalDate borrowDate = dpIssueDate.getValue();
        LocalDate dueDate = dpDueDate.getValue();

        String bookId = selectedBook.getIsbn();
        String memberId = selectedMember.getMemberId();

        controller.IssueBook(
                bookId,
                memberId,
                borrowDate,
                dueDate
        );

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cmbSelectBook.setItems(controller.getBookIdName());
        cmbSelectMember.setItems(controller.getMembeIdAndName());
    }
}
