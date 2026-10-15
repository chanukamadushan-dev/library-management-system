package controllers;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import model.ManageMembers;

import java.awt.event.WindowStateListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Manage_Member_Controller {
    private static Manage_Member_Controller instance;

    private Manage_Member_Controller() {
    }

    Connection connection = DBConnection.getInstance().getConnection();


    public void addMember(
            String memberId,
            String memberName,
            String memberMail,
            String contact,
            String address
    ) {

        String SQL = "INSERT INTO patrons VALUES " +
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

    public ObservableList<ManageMembers> getAllMembers() {

        ObservableList<ManageMembers> memberList = FXCollections.observableArrayList();

        String SQL = "SELECT member_id, full_name, email, contact, adress FROM patrons";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ManageMembers member = new ManageMembers(
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

    public ManageMembers searchMember(String id) {


        String SQL = "SELECT member_id, full_name, email, contact, adress FROM patrons WHERE member_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new ManageMembers(
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

    public static Manage_Member_Controller getInstance() {
        if (instance == null) {
            instance = new Manage_Member_Controller();
        }
        return instance;
    }
}
