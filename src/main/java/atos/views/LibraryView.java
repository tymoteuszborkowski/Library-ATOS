package atos.views;

import atos.model.Book;

import java.util.List;

public class LibraryView {

    public void printOneBook(Book book){
        System.out.println("----------------");
        System.out.println("ID: " + book.getId());
        System.out.println("TITLE: " + book.getTitle());
        System.out.println("AUTHOR: " + book.getAuthor());
        System.out.println("YEAR: " + book.getYear());
        if(book.getBorrower() != null) System.out.println("BORROWER: " + book.getBorrower());
        System.out.println("----------------");
    }

    public void printBooks(List<Book> books){
        books.forEach(this::print);
    }

    public void lendPrint(boolean isLent){
        if(isLent){
            System.out.println("Book successfully lent.");
        }else {
            System.out.println("Can't lend this book.");
        }
    }

    public void removePrint(boolean canRemove){
        if(canRemove){
            System.out.println("Successfully removed.");
        }else {
            System.out.println("Can't remove this book.");
        }
    }
    public void printMsg(String msg){
        System.out.println(msg);
    }

    private void print(Book book){
        System.out.println("----------------");
        System.out.println("ID: " + book.getId());
        System.out.println("TITLE: " + book.getTitle());
        System.out.println("AUTHOR: " + book.getAuthor());
        System.out.println("YEAR: " + book.getYear());
        System.out.println("----------------");
    }

}
