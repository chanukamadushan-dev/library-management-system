package controllers;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Books;
import model.Members;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueBookController {

    Connection connection = DBConnection.getInstance().getConnection();

    public ObservableList<Members> getMembeIdAndName(){

        ObservableList<Members> memberList = FXCollections.observableArrayList();

        String SQL = "SELECT member_id, full_name FROM patrons";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Members member = new Members(
                        resultSet.getString("member_id"),
                        resultSet.getString("full_name")

                );
                memberList.add(member);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return memberList;
    }

    public ObservableList<Books> getBookIdName(){

        ObservableList<Books> bookList = FXCollections.observableArrayList();

        String SQL = "SELECT ISBN, book_title FROM books";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Books book = new Books(
                        resultSet.getString("ISBN"),
                        resultSet.getString("book_title")
                );
                bookList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return bookList;
    }
}
