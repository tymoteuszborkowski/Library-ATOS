package atos.configuration;

import atos.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfig {

    @Bean
    public List<Book> bookList(){
        return new ArrayList<>();
    }
}
