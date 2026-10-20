package controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Issue;
import model.IssueData;
import scene.SceneManager;

public class BorrowingHistoryPageController {

    @FXML
    private TableColumn<Issue, String> colmBookTitle;

    @FXML
    private TableColumn<Issue, String > colmDueDate;

    @FXML
    private TableColumn<Issue, String > colmIssueDate;

    @FXML
    private TableColumn<Issue, String> colmMemberID;

    @FXML
    private TableColumn<Issue, String> colmReturnDate;

    @FXML
    private TableColumn<Issue, String> colmStatus;

    @FXML
    private TableView<Issue> tblBorrowingHistory;

    @FXML
    public void initialize() {

        tblBorrowingHistory.setItems(IssueData.getIssueList());

        colmMemberID.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMember().getMemberId()));

        colmBookTitle.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBook().getBookName()));

        colmIssueDate.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIssueDate()).asString());

        colmDueDate.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDueDate()).asString());

        colmReturnDate.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getReturnDate()).asString());

        colmStatus.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {

        SceneManager.switchPgae("/view/main_dashboard.fxml");
    }
}
