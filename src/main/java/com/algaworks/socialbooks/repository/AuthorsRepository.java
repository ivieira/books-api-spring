package com.algaworks.socialbooks.repository;

import com.algaworks.socialbooks.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Author, Long> {

}
