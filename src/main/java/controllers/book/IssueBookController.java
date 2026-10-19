package controllers.book;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Books;
import model.Members;

import java.sql.*;
//import java.util.Date;
import java.sql.Date;
import java.time.LocalDate;

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

    public void IssueBook(

            String bookId,
            String memberId,
            LocalDate borrowDate,
            LocalDate dueDate

    ){
        String SQL = "INSERT INTO borrwings(book_id, member_id, borrow_date, due_date) " +
                     "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,bookId);
            preparedStatement.setString(2,memberId);
            preparedStatement.setDate(3, Date.valueOf(borrowDate));
            preparedStatement.setDate(4, Date.valueOf(dueDate));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
