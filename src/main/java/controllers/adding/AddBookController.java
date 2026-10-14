package controllers.adding;

import db.DBConnection;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBookController {

    private static AddBookController instance;

    private AddBookController(){}

    Connection connection = DBConnection.getInstance().getConnection();

    public void addBook(
         String isbn,
         String bookTitle,
         String author,
         String category,
         int publishYear,
         int quantity
    ){

        String SQL = "INSERT INTO books VALUES " +
                            "(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, isbn);
            preparedStatement.setString(2, bookTitle);
            preparedStatement.setString(3, author);
            preparedStatement.setString(4, category);
            preparedStatement.setInt(5, publishYear);
            preparedStatement.setInt(6, quantity);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static AddBookController getInstance(){
        if(instance == null){
            instance = new AddBookController();
        }
        return instance;
    }

}
