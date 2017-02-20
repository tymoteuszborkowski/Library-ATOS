package atos.interfaces;

import atos.model.Book;

import java.util.List;

public interface BookRepository {

    void addBook(String title, String author, int year);
    boolean removeBook(String id);

    Book findBookById(String id);
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByYear(int year);
    List<Book> findBooksByTitleAndYear(String title, int year);
    List<Book> findBooksByAuthorAndYear(String author, int year);
    List<Book> findBooksByTitleAndAuthor(String title, String author);
    List<Book> findExactBook(String title, String author, int year);
    List<Book> findAllBooks();

}
