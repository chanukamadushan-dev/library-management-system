package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.Issue;
import model.IssueData;

import java.time.LocalDate;

public class Rerturn_BookPage_Controller {

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

        if (selectedIssue == null) {
            return;
        }

        LocalDate returnDate = LocalDate.now();

        selectedIssue.setReturnDate(returnDate);

        if (returnDate.isAfter(selectedIssue.getDueDate())) {
            selectedIssue.setStatus("Overdue");
        } else {
            selectedIssue.setStatus("Returned");
        }

        cmbSearchbyBook.getItems().remove(selectedIssue);

        clearFields();
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
    public void initialize() {

        for (Issue issue : IssueData.getIssueList()) {

            if (issue.getStatus().equals("Borrowed")) {
                cmbSearchbyBook.getItems().add(issue);
            }
        }
    }

    @FXML
    private void selectBook() {

        Issue selectedIssue = cmbSearchbyBook.getValue();

        if (selectedIssue != null) {

            lblMemberID.setText(
                    selectedIssue.getMember().getMemberId()
            );

            lblMemberName.setText(
                    selectedIssue.getMember().getMemberName()
            );

            lblBorrowedDate.setText(
                    selectedIssue.getIssueDate().toString()
            );

            lblDueDate.setText(
                    selectedIssue.getDueDate().toString()
            );
        }
    }

}
