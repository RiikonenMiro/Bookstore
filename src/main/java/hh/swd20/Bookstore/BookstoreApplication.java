package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			Category c1 = new Category("Scifi");
			Category c2 = new Category("Horror");
			Category c3 = new Category("Romance");
			
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			
			Book b1 = new Book("Harry Potter", "JK Rowling", 2005, "9785343463212", 24, c1);
			Book b2 = new Book("Lord of the rings", "J.R.R. Tolkien", 1954, "9785348768678", 19, c2);
			
			brepository.save(b1);
			brepository.save(b2);
			
			
		};
	}

}
