package controllers.member;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Members;
import scene.SceneManager;

import java.util.Locale;

public class ManageMemberPageController {

    ManageMemberController memberController = ManageMemberController.getInstance();


    private Members selectedMember;
    @FXML
    private Button btnDeleteMember;

    @FXML
    public Button btnMemberRegister;

    @FXML
    private Button btnSearchMember;

    @FXML
    private Button btnUpdateMember;

    @FXML
    private TableColumn<Members, String> colmAddress;

    @FXML
    private TableColumn<Members, String> colmEmail;

    @FXML
    private TableColumn<Members, String> colmMemberId;

    @FXML
    private TableColumn<Members, String> colmMemberName;

    @FXML
    private TableColumn<Members, String> colmPhoneNumber;

    @FXML
    private TableView<Members> tblMemberDetails;

    @FXML
    private TextField txtMemberAddress;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtMemberMail;

    @FXML
    private TextField txtMemberName;

    @FXML
    private TextField txtMemberPhone;

    @FXML
    private TextField txtSearchMember;

    @FXML
    public void initialize() {
        colmMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colmMemberName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        colmEmail.setCellValueFactory(new PropertyValueFactory<>("memberEmail"));
        colmPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("memberPhone"));
        colmAddress.setCellValueFactory(new PropertyValueFactory<>("memberAddress"));

        tblMemberDetails.setItems(memberController.getAllMembers());
    }

    @FXML
    void txtMemberAddressOnAction(ActionEvent event) {
        btnMemberRegisterOnAction(event);
    }

    @FXML
    void txtMemberIDOnAction(ActionEvent event) {
        txtMemberName.requestFocus();
    }

    @FXML
    void txtMemberMailOnAction(ActionEvent event) {
        txtMemberPhone.requestFocus();
    }

    @FXML
    void txtMemberNameOnAction(ActionEvent event) {
        txtMemberMail.requestFocus();
    }

    @FXML
    void txtMemberPhoneOnAction(ActionEvent event) {
        txtMemberAddress.requestFocus();
    }

    @FXML
    void txtSearchMemberOnAction(ActionEvent event) {
        btnSearchMemberOnAction(event);
    }

    @FXML
    void clearField() {
        txtMemberID.clear();
        txtMemberName.clear();
        txtMemberAddress.clear();
        txtMemberMail.clear();
        txtMemberPhone.clear();
    }

    @FXML
    void btnDeleteMemberOnAction(ActionEvent event) {
        memberController.deleteMember(txtSearchMember.getText());
        clearField();
        tblMemberDetails.refresh();
    }

    @FXML
    void btnSearchMemberOnAction(ActionEvent event) {
        if (!(txtSearchMember.getText().isEmpty())) {
            selectedMember = memberController.searchMember(txtSearchMember.getText());

            if (selectedMember != null) {
                txtMemberID.setText(selectedMember.getMemberId());
                txtMemberName.setText(selectedMember.getMemberName());
                txtMemberMail.setText(selectedMember.getMemberEmail());
                txtMemberPhone.setText(selectedMember.getMemberPhone());
                txtMemberAddress.setText(selectedMember.getMemberAddress());
            }
        }
    }

    @FXML
    void btnUpdateMemberOnAction(ActionEvent event) {

        memberController.updateMember(
                txtMemberID.getText(),
                txtMemberName.getText(),
                txtMemberMail.getText(),
                txtMemberPhone.getText(),
                txtMemberAddress.getText()
        );

        tblMemberDetails.setItems(memberController.getAllMembers());
        tblMemberDetails.refresh();

    }

    public void btnClearFieldsOnAction(ActionEvent actionEvent) {
        clearField();
    }

    public void showError(String message){

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Validation error");
        alert.setHeaderText("Invalid member details");
        alert.setContentText(message);

        alert.showAndWait();
    }

    public void btnMemberRegisterOnAction(ActionEvent actionEvent) {

        String id = txtMemberID.getText().trim();
        String name = txtMemberName.getText().trim();
        String email = txtMemberMail.getText().trim();
        String number = txtMemberPhone.getText().trim();
        String address = txtMemberAddress.getText().trim();

        if (id.isEmpty() || name.isEmpty() || email.isEmpty() || number.isEmpty() ||  address.isEmpty()){
            showError("Please fill all fields !");
            return;
        }

        if (memberController.searchMember(id) != null){

            showError("This id already exists");
            txtMemberID.requestFocus();
            return;
        }

        if (!name.matches("[\\p{L} ]+")) {
            showError("Name can contain letters only");
            txtMemberName.requestFocus();
            return;
        }

        if (!number.matches("\\+?[0-9]+")) {
            showError("The phone number cannot contain letters");
            txtMemberPhone.requestFocus();
            return;
        }

        if (number.length() > 15) {
            showError("Phone number cannot exceed 20 characters");

            return;
        }
        memberController.addMember(
                txtMemberID.getText(),
                txtMemberName.getText(),
                txtMemberMail.getText(),
                txtMemberPhone.getText(),
                txtMemberAddress.getText()
        );
        tblMemberDetails.setItems(memberController.getAllMembers());
        clearField();
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {

        SceneManager.switchPgae("/view/main_dashboard.fxml");
    }
}
