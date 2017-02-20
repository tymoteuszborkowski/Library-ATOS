package atos.controllers;

import atos.interfaces.BookRepository;
import atos.interfaces.BookService;
import atos.model.Book;
import atos.views.LibraryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LibraryController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    private LibraryView view = new LibraryView();


    public void addBook(String title, String author, int year){
        bookRepository.addBook(title, author, year);
        view.printMsg("Added new book.");
    }

    public void removeBook(String id){
        boolean canRemove = bookRepository.removeBook(id);
        view.removePrint(canRemove);
    }

    public void lendBookById(String id, String borrower){
        boolean isLent = bookService.lendBookById(id, borrower);
        view.lendPrint(isLent);
    }


    public void displayBooksByTitle(String title){
        List<Book> books = bookRepository.findBooksByTitle(title);
        view.printBooks(books);
    }


    public void displayBookById(String id){
        Book book = bookRepository.findBookById(id);
        if(book != null){
            view.printOneBook(book);
        }else {
            view.printMsg("Book not found.");
        }
    }

    public void displayBooksByAuthor(String author){
        List<Book> books = bookRepository.findBooksByAuthor(author);
        view.printBooks(books);
    }

    public void displayBooksByYear(int year){
        List<Book> books = bookRepository.findBooksByYear(year);
        view.printBooks(books);
    }

    public void displayBooksByTitleAndYear(String title, int year){
        List<Book> books = bookRepository.findBooksByTitleAndYear(title, year);
        view.printBooks(books);
    }

    public void displayBooksByAuthorAndYear(String author, int year){
        List<Book> books = bookRepository.findBooksByAuthorAndYear(author, year);
        view.printBooks(books);
    }

    public void displayBooksByTitleAndAuthor(String title, String author){
        List<Book> books = bookRepository.findBooksByTitleAndAuthor(title, author);
        view.printBooks(books);
    }

    public void displayExactBook(String title, String author, int year){
        List<Book> books = bookRepository.findExactBook(title, author, year);
        view.printBooks(books);
    }


    public void displayAllBooks(){
        List<Book> books = bookRepository.findAllBooks();
        view.printBooks(books);
    }


}
