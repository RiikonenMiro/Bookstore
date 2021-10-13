package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
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
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
		};
	}

}
