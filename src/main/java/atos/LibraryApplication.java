package atos;

import atos.controllers.LibraryController;
import atos.interfaces.BookRepository;
import atos.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class LibraryApplication {

	@Autowired
	private LibraryController controller;

	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@PostConstruct
	public void init(){
        printTests();
	}

	private void printTests(){
		System.out.println("__________________________________________________________________");
		System.out.println("Adding two books");
		System.out.println("Metro 2033 - Dmitrij Głuchowski - 2005");
		System.out.println("Metro 2039 - Dmitrij Głuchowski - 2123");
			controller.addBook("Metro 2033", "Dmitrij Głuchowski", 2005 );
			controller.addBook("Metro 2039", "Dmitrij Głuchowski", 2123);
		System.out.println("__________________________________________________________________");

		System.out.println("Finding book - Metro 2039 - Dmitrij Głuchowski - 2123");
			List<Book> foundBooks = repository.findExactBook("Metro 2039", "Dmitrij Głuchowski", 2123);
		System.out.println("__________________________________________________________________");


		for (Book book : foundBooks) {
			System.out.println("Lending this book.");
				controller.lendBookById(book.getId(), "Marta Pętal");
			System.out.println("__________________________________________________________________");

			System.out.println("Removing this book. Should not be possible, because is currently lent.");
				controller.removeBook(book.getId());
			System.out.println("__________________________________________________________________");

			System.out.println("Trying to lend again.");
				controller.lendBookById(book.getId(), "Marta Pętal");
			System.out.println("__________________________________________________________________");
		}

		System.out.println("Displaying books by title: Metro 2033 ");
			controller.displayBooksByTitle("Metro 2033");
		System.out.println("__________________________________________________________________");

		System.out.println("Displaying books by id: -- ");
			controller.displayBookById("--");
		System.out.println("__________________________________________________________________");

		System.out.println("Displaying books by author: Dmitrij Głuchowski");
			controller.displayBooksByAuthor("Dmitrij Głuchowski");
		System.out.println("__________________________________________________________________");

		System.out.println("Displaying books by year: 2123");
			controller.displayBooksByYear(2123);
		System.out.println("__________________________________________________________________");

		System.out.println("Displaying books by title and year: Metro 2033 - 2123");
			controller.displayBooksByTitleAndYear("Metro 2033", 2123);
		System.out.println("__________________________________________________________________");

		System.out.println("Displaying books by author and year: Dmitrij Głuchowski - 2007 ");
			controller.displayBooksByAuthorAndYear("Dmitrij Głuchowski", 2007);
		System.out.println("__________________________________________________________________");

		System.out.println("Displaying books by title and author: Metro 2033 - Dmitrij Głuchowski");
			controller.displayBooksByTitleAndAuthor("Metro 2033", "Dmitrij Głuchowski");
		System.out.println("__________________________________________________________________");

		System.out.println("Displaying books by title, author and year: Metro 2033 - Dmitrij Głuchowski - 2005");
			controller.displayExactBook("Metro 2033", "Dmitrij Głuchowski", 2005);
		System.out.println("__________________________________________________________________");

		System.out.println("Displaying all books.");
			controller.displayAllBooks();
		System.out.println("__________________________________________________________________");
	}

}
