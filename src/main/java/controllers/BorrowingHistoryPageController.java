package controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Issue;
import model.IssueData;
import scene.SceneManager;

import java.sql.Date;
import java.time.LocalDate;

public class BorrowingHistoryPageController {

    BorrowHistoryController borrowHistoryController = new BorrowHistoryController();

    @FXML
    private TableColumn<Issue, String> colmBookTitle;

    @FXML
    private TableColumn<Issue, LocalDate> colmDueDate;

    @FXML
    private TableColumn<Issue, LocalDate > colmIssueDate;

    @FXML
    private TableColumn<Issue, String> colmMemberID;

    @FXML
    private TableColumn<Issue, LocalDate> colmReturnDate;

    @FXML
    private TableColumn<Issue, String> colmStatus;

    @FXML
    private TableView<Issue> tblBorrowingHistory;

    @FXML
    public void initialize() {

        colmMemberID.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colmBookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colmIssueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colmDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colmReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));

        tblBorrowingHistory.setItems(borrowHistoryController.getData());

    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {

        SceneManager.switchPgae("/view/main_dashboard.fxml");
    }
}
