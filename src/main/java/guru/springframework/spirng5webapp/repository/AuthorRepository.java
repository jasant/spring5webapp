package guru.springframework.spirng5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spirng5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
