package controllers.book;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Issue;

import java.sql.*;
import java.time.LocalDate;

public class ReturnBookController {
    Connection connection = DBConnection.getInstance().getConnection();

    public ObservableList<Issue> getBorrowBook() {

        ObservableList<Issue> issueList = FXCollections.observableArrayList();
        String SQL = "SELECT borrowing_id, book_id FROM borrwings";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Issue issue = new Issue(
                        resultSet.getInt("borrowing_id"),
                        resultSet.getString("book_id")
                );
                issueList.add(issue);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return issueList;
    }

    public ObservableList<Issue> getBorrowData() {
        ObservableList<Issue> borrowList = FXCollections.observableArrayList();

        String SQL = "select bw.borrowing_id, p.member_id, b.book_title, p.full_name, bw.borrow_date, bw.due_date\n" +
                "from borrwings bw\n" +
                "join books b\n" +
                "on b.ISBN = bw.book_id\n" +
                "join patrons p\n" +
                "on p.member_id = bw.member_id " +
                "WHERE bw.return_date IS NULL;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Issue issue = new Issue(
                        resultSet.getInt("bw.borrowing_id"),
                        resultSet.getString("b.book_title"),
                        resultSet.getString("p.member_id"),
                        resultSet.getString("p.full_name"),
                        resultSet.getDate("bw.borrow_date").toLocalDate(),
                        resultSet.getDate("bw.due_date").toLocalDate()
                        );
                borrowList.add(issue);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return borrowList;
    }

    public void setDate(
            int borrowId,
            LocalDate returnDate
    ) {
        String SQL = "UPDATE borrwings SET return_date = ? WHERE borrowing_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setDate(1, Date.valueOf(returnDate));
            preparedStatement.setInt(2,borrowId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
