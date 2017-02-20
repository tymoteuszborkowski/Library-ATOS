package atos;

import atos.controllers.LibraryController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LibraryControllerTest {

    @Autowired
    private LibraryController controller;

    @Test
    public void addBooks() {
        addRandomBooks();
        controller.displayAllBooks();
    }

    @Test
    public void authorsBooks() {
        addRandomBooks();
    }


    private void addRandomBooks() {
        controller.addBook("Mały Książę", "Antoine de Saint-Exupéry", 1943);
        controller.addBook("Harry Potter i Czara Ognia", "J.K. Rowling", 2000);
        controller.addBook("Sto lat samotności", "Gabriel García Márquez", 1967);
        controller.addBook("Dziennik Anny Frank", "Anne Frank", 1947);
        controller.addBook("Jądro ciemności", "Joseph Conrad", 1899);
        controller.addBook("Mistrz i Małgorzata", "Michaił Bułhakow", 1966);
        controller.addBook("Zabójstwo Rogera Ackroyda", "Agata Christie", 1926);
        controller.addBook("Dżuma", "Albert Camus", 1947);
        controller.addBook("Proces", "Franz Kafka", 1925);
        controller.addBook("Umiłowana", "Toni Morrison", 1987);
        controller.addBook("Harry Potter i Kamień Filozoficzny", "J.K Rowling", 1997);
    }
}
