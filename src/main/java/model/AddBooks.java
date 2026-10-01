package model;

public class AddBooks {
    private String isbn;
    private String bookName;
    private String author;
    private String category;
    private String year;
    private String quantity;

    public AddBooks(String isbn, String bookName, String author, String category, String year, String quantity) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.year = year;
        this.quantity = quantity;
    }
}
