package model;

import java.time.LocalDate;

public class Issue {
    private ManageMembers member;
    private AddBooks book;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private String status;

//    public Issue(ManageMembers member, AddBooks book, LocalDate issueDate, LocalDate dueDate) {
//        this.member = member;
//        this.book = book;
//        this.issueDate = issueDate;
//        this.dueDate = dueDate;
//    }

    public Issue(ManageMembers member, AddBooks book, LocalDate issueDate, LocalDate dueDate) {
        this.member = member;
        this.book = book;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = "Borrowed";
    }

    public ManageMembers getMember() {
        return member;
    }

    public AddBooks getBook() {
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

    public void setMember(ManageMembers member) {
        this.member = member;
    }

    public void setBook(AddBooks book) {
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

    @Override
    public String toString() {
        return book.getIsbn()+" - "+book.getBookName();
    }
}
