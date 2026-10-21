package controllers.dashboard;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Books;
import model.Issue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainDashboardController {

    Connection connection = DBConnection.getInstance().getConnection();

    public int getBookCount() {

        String SQL = "select sum(b.quantity)\n" +
                "from books b;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;

    }

    public int getMemberCount() {

        String SQL = "select count(p.member_id)\n" +
                "from patrons p;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int getBorrowedBookCount() {

        String SQL = "select count(bw.borrowing_id)\n" +
                "from borrwings bw;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;

    }

    public int getOverdueBookCount() {

        String SQL = "select count(borrowing_id)\n" +
                "from borrwings\n" +
                "where current_date>due_date;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;

    }

    public ObservableList<Issue> getTableData() {

        ObservableList<Issue> tableList = FXCollections.observableArrayList();

        String SQL = "select b. book_title, p.full_name, bw.borrow_date, bw.due_date\n" +
                "from borrwings bw\n" +
                "join books b on bw.book_id = b.isbn\n" +
                "join patrons p on bw.member_id = p.member_id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Issue issue = new Issue(
                        resultSet.getString("b.book_title"),
                        resultSet.getString("p.full_name"),
                        resultSet.getDate("bw.borrow_date").toLocalDate(),
                        resultSet.getDate("bw.due_date").toLocalDate()
                );
                tableList.add(issue);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return tableList;
    }
}
