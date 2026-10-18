package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BookData {

    private static ObservableList<Books> bookList = FXCollections.observableArrayList();

    public static void addBook(Books book) {
        bookList.add(book);
    }

    public static ObservableList<Books> getBookList(){
        return bookList;
    }
}
