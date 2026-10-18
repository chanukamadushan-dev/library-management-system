package controllers.member;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageMemberController {
    private static ManageMemberController instance;

    private ManageMemberController() {
    }

    Connection connection = DBConnection.getInstance().getConnection();


    public void addMember(
            String memberId,
            String memberName,
            String memberMail,
            String contact,
            String address
    ) {

        String SQL = "INSERT INTO patrons(member_id, full_name, email, contact, adress) VALUES " +
                "(?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, memberId);
            preparedStatement.setString(2, memberName);
            preparedStatement.setString(3, memberMail);
            preparedStatement.setString(4, contact);
            preparedStatement.setString(5, address);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Members> getAllMembers() {

        ObservableList<Members> memberList = FXCollections.observableArrayList();

        String SQL = "SELECT member_id, full_name, email, contact, adress FROM patrons";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Members member = new Members(
                        resultSet.getString("member_id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("contact"),
                        resultSet.getString("adress")
                );

                memberList.add(member);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return memberList;
    }

    public Members searchMember(String id) {


        String SQL = "SELECT member_id, full_name, email, contact, adress FROM patrons WHERE member_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new Members(
                        resultSet.getString("member_id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("contact"),
                        resultSet.getString("adress")

                );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateMember(
            String memberId,
            String memberName,
            String memberMail,
            String contact,
            String address
    ) {
        String SQL = "UPDATE patrons " +
                     "SET  full_name = ?, email = ?, contact = ?, adress = ? " +
                     "WHERE member_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, memberName);
            preparedStatement.setString(2, memberMail);
            preparedStatement.setString(3, contact);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, memberId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMember(String id){

        String SQL = "DELETE FROM patrons WHERE member_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ManageMemberController getInstance() {
        if (instance == null) {
            instance = new ManageMemberController();
        }
        return instance;
    }
}
