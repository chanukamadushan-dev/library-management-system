package controllers;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Issue;

import java.sql.*;

public class BorrowHistoryController {

    Connection connection = DBConnection.getInstance().getConnection();

    public ObservableList<Issue> getData(){

        ObservableList<Issue> borrowList = FXCollections.observableArrayList();
        String SQL = "select  p.member_id, b.book_title, bw.borrow_date, bw.due_date, bw.return_date,\n" +
                "case \n" +
                "    when bw.return_date is null then\n" +
                "        'Not returned'\n" +
                "    when bw.return_date is not null and bw.due_date > bw.return_date then\n" +
                "        'Returned'\n" +
                "    when current_date > bw.due_date then\n" +
                "        'overDue'\n" +
                "end as status\n" +
                "from borrwings bw\n" +
                "join books b\n" +
                "on b.ISBN = bw.book_id\n" +
                "join patrons p\n" +
                "on p.member_id = bw.member_id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Date sqlIssuDate = resultSet.getDate("bw.borrow_date");
                Date sqlDueDate = resultSet.getDate("bw.due_date");
                Date sqlReturnDate = resultSet.getDate("bw.return_date");
                Issue issue = new Issue(
                        resultSet.getString("p.member_id"),
                        resultSet.getString("b.book_title"),
                        sqlIssuDate != null ? sqlIssuDate.toLocalDate() : null,
                        sqlDueDate != null ? sqlDueDate.toLocalDate() : null,
                        sqlReturnDate != null ? sqlReturnDate.toLocalDate() : null,
                        resultSet.getString("status")


                );
                borrowList.add(issue);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return borrowList;
    }

}
