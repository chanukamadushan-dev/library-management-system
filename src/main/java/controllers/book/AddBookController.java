package controllers.book;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Books;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public ObservableList<Books> getAllBooks(){
        ObservableList<Books> bookList = FXCollections.observableArrayList();

        String SQL = "SELECT ISBN, book_title, author, category, publish_year, quantity FROM books ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Books book = new Books(
                        resultSet.getString("ISBN"),
                        resultSet.getString("book_title"),
                        resultSet.getString("author"),
                        resultSet.getString("category"),
                        resultSet.getString("publish_year"),
                        resultSet.getString("quantity")

                );
                bookList.add(book);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    public static AddBookController getInstance(){
        if(instance == null){
            instance = new AddBookController();
        }
        return instance;
    }

}
