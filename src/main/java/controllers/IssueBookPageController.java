package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class IssueBookPageController implements Initializable {


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


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
