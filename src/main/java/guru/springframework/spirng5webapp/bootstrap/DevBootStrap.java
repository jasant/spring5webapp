package guru.springframework.spirng5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spirng5webapp.model.Author;
import guru.springframework.spirng5webapp.model.Book;
import guru.springframework.spirng5webapp.model.Publisher;
import guru.springframework.spirng5webapp.repository.AuthorRepository;
import guru.springframework.spirng5webapp.repository.BookRepository;
import guru.springframework.spirng5webapp.repository.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	private void initData() {

		Publisher harper = new Publisher("Harper Collins", "Local 123");
		publisherRepository.save(harper);

		// Eric
		Author eric = new Author("Eric", "Evans");

		Book ddd = new Book("Domain Driver Design", "1234", harper);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);

		// Rod
		Author rod = new Author("Rod", "Johnson");

		Book noEJB = new Book("J2EE Development without EJ8", "2344", harper);
		rod.getBooks().add(noEJB);
		authorRepository.save(rod);
		bookRepository.save(noEJB);

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();

	}

}
