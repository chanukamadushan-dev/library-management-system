package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Members;

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

    public void btnMemberRegisterOnAction(ActionEvent actionEvent) {
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
}
