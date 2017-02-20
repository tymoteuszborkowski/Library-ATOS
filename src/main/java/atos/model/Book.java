package atos.model;

import java.util.UUID;

public class Book {

    private final String id;

    private String title;
    private String author;
    private int year;
    private boolean isLent = false;

    private String borrower;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.id = UUID.randomUUID().toString();
    }

    public String getBorrower() {
        return borrower;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLent() {
        return isLent;
    }

    public boolean tryLend(String borrower) {
        if(!isLent){
            isLent = true;
            this.borrower = borrower;
            return true;
        }else {
            return false;
        }
    }



}
