package model;

import java.util.ArrayList;

public class BookData {

    private static ArrayList<AddBooks> books = new ArrayList<>();

    public static void addBook(AddBooks book) {
        books.add(book);
    }

    public static ArrayList<AddBooks> getBooks(){
        return books;
    }
}
