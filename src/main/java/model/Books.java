package model;

public class Books {
    private String isbn;
    private String bookName;
    private String author;
    private String category;
    private String year;
    private String quantity;


    public Books(){}
    public Books(String isbn, String bookName, String author, String category, String year, String quantity) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.year = year;
        this.quantity = quantity;
    }

    public Books(String isbn, String bookName) {
        this.isbn = isbn;
        this.bookName = bookName;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getYear() {
        return year;
    }


    @Override
    public String toString() {
        return isbn +" - "+bookName;
    }
}
