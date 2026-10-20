package model;

import java.time.LocalDate;

public class Issue {
    private int borrowId;
    private String memberId;
    private String bookTitle;
    private String memberName;
    private Members member;
    private Books book;
    private String bookId;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private String status;


    public Issue(Members member, Books book, LocalDate issueDate, LocalDate dueDate) {
        this.member = member;
        this.book = book;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = "Borrowed";
    }

    public Issue(String memberId, String bookTitle, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        this.memberId = memberId;
        this.bookTitle = bookTitle;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public Issue(int borrowId, String bookTitle, String memberId, String memberName, LocalDate issueDate, LocalDate dueDate) {
        this.borrowId = borrowId;
        this.bookTitle = bookTitle;
        this.memberId = memberId;
        this.memberName = memberName;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public Issue(int borrowId, String bookId) {
        this.borrowId = borrowId;
        this.bookId = bookId;
    }

    public Members getMember() {
        return member;
    }

    public Books getBook() {
        return book;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setMember(Members member) {
        this.member = member;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    @Override
    public String toString() {
        return borrowId+" - "+bookTitle;
    }
}
