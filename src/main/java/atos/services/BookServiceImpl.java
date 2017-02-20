package atos.services;

import atos.interfaces.BookRepository;
import atos.interfaces.BookService;
import atos.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean lendBookById(String id, String borrower) {
        Book book = bookRepository.findBookById(id);
        return book != null && book.tryLend(borrower);
    }

}
