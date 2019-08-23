package guru.springframework.spirng5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spirng5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
