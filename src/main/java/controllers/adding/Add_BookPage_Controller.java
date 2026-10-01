package controllers.adding;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AddBooks;
import model.BookData;

public class Add_BookPage_Controller {

    @FXML
    private Button btnBookAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnClear;

    @FXML
    private TableColumn<?, ?> clmAuthor;

    @FXML
    private TableColumn<?, ?> clmBookId;

    @FXML
    private TableColumn<?, ?> clmBookName;

    @FXML
    private TableColumn<?, ?> clmCategory;

    @FXML
    private TableColumn<?, ?> clmQuantoty;

    @FXML
    private TableColumn<?, ?> clmYear;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtYear;

    @FXML
    void txtAuthorOnAction(ActionEvent event) {
        txtCategory.requestFocus();
    }

    @FXML
    void txtBookIDOnAction(ActionEvent event) {
        txtBookName.requestFocus();
    }

    @FXML
    void txtBookNameOnAction(ActionEvent event) {
        txtAuthor.requestFocus();
    }

    @FXML
    void txtCategoryOnAction(ActionEvent event) {
        txtYear.requestFocus();
    }

    @FXML
    void txtQuantityOnAction(ActionEvent event) {
        btnBookAdOnAction(event);
    }

    @FXML
    void txtYearOnAction(ActionEvent event) {
        txtQuantity.requestFocus();
    }

    @FXML
    void btnBookAdOnAction(ActionEvent event) {
        AddBooks book = new AddBooks(
                txtBookID.getText(),
                txtBookName.getText(),
                txtAuthor.getText(),
                txtCategory.getText(),
                txtYear.getText(),
                txtQuantity.getText()
        );

        BookData.addBook(book);
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtBookID.setText("");
        txtBookName.setText("");
        txtAuthor.setText("");
        txtCategory.setText("");
        txtYear.setText("");
        txtQuantity.setText("");
    }

}
