package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.*;

import java.time.LocalDate;

public class Issue_BookPage_Controller {


    @FXML
    private Button btnIssueBook;

    @FXML
    private ComboBox<AddBooks> cmbSelectBook;

    @FXML
    private ComboBox<ManageMembers> cmbSelectMember;

    @FXML
    public DatePicker dpIssueDate;

    @FXML
    public DatePicker dpDueDate;

    @FXML
    private void issueBook(){
        ManageMembers member = cmbSelectMember.getValue();
        AddBooks book = cmbSelectBook.getValue();

        LocalDate issuDate = dpIssueDate.getValue();
        LocalDate dueDate = dpDueDate.getValue();
    }

    @FXML
    void initialize(){
        cmbSelectMember.setItems(MemberData.getMemberList());
        cmbSelectBook.setItems(BookData.getBookList());
    }

    @FXML
    void cmbSelectBookOnAction(ActionEvent event) {

    }

    @FXML
    void cmbSelectMemberOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {

        Issue issue = new Issue(
                cmbSelectMember.getValue(),
                cmbSelectBook.getValue(),
                dpIssueDate.getValue(),
                dpDueDate.getValue()
        );


        IssueData.issueList.add(issue);

        cmbSelectBook.setValue(null);
        cmbSelectMember.setValue(null);
        dpDueDate.setValue(null);
        dpIssueDate.setValue(null);
    }

}
