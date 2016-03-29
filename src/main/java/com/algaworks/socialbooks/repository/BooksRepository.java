package com.algaworks.socialbooks.repository;

import com.algaworks.socialbooks.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
