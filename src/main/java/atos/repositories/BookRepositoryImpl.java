package atos.repositories;

import atos.interfaces.BookRepository;
import atos.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository{

    @Autowired
    private List<Book> books;

    @Override
    public void addBook(String title, String author, int year) {
        books.add(new Book(title, author, year));
    }

    @Override
    public boolean removeBook(String id) {
        Book bookById = findBookById(id);

        if(bookById == null){
            return false;
        }else if(bookById.isLent()){
            return false;
        }else {
            books.remove(bookById);
            return true;
        }
    }

    @Override
    public Book findBookById(String id) {
        return books.stream()
                .filter(book -> (book.getId().equals(id)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        List<Book> fBooks = new ArrayList<>();

         books.stream()
                .filter(book -> (book.getTitle().equals(title)))
                .forEach(fBooks::add);

        return fBooks;
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        List<Book> fBooks = new ArrayList<>();

        books.stream()
                .filter(book -> (book.getAuthor().equals(author)))
                .forEach(fBooks::add);

        return fBooks;
    }

    @Override
    public List<Book> findBooksByYear(int year) {
        List<Book> fBooks = new ArrayList<>();

        books.stream()
                .filter(book -> (book.getYear() == year))
                .forEach(fBooks::add);

        return fBooks;
    }

    @Override
    public List<Book> findBooksByTitleAndYear(String title, int year) {
        List<Book> fBooks = new ArrayList<>();

        books.stream()
                .filter(book -> (book.getTitle().equals(title)) && (book.getYear() == year))
                .forEach(fBooks::add);

        return fBooks;
    }

    @Override
    public List<Book> findBooksByAuthorAndYear(String author, int year) {
        List<Book> fBooks = new ArrayList<>();

        books.stream()
                .filter(book -> (book.getAuthor().equals(author)) && (book.getYear() == year))
                .forEach(fBooks::add);

        return fBooks;
    }

    @Override
    public List<Book> findBooksByTitleAndAuthor(String title, String author) {
        List<Book> fBooks = new ArrayList<>();

        books.stream()
                .filter(book -> (book.getTitle().equals(title)) && (book.getAuthor().equals(author)))
                .forEach(fBooks::add);

        return fBooks;
    }

    @Override
    public List<Book> findExactBook(String title, String author, int year) {
        List<Book> fBooks = new ArrayList<>();

        books.stream()
                .filter(book -> (book.getTitle().equals(title)) && (book.getAuthor().equals(author) && (book.getYear() == year)))
                .forEach(fBooks::add);

        return fBooks;
    }

    @Override
    public List<Book> findAllBooks() {
        return books;
    }


}
