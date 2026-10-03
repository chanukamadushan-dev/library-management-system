package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BookData {

    private static ObservableList<AddBooks> bookList = FXCollections.observableArrayList();

    public static void addBook(AddBooks book) {
        bookList.add(book);
    }

    public static ObservableList<AddBooks> getBookList(){
        return bookList;
    }
}
