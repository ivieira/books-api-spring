package com.algaworks.socialbooks.resources;

import com.algaworks.socialbooks.domain.Book;
import com.algaworks.socialbooks.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksResources {

    @Autowired
    private BooksRepository booksRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> list() {
        return booksRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Book book) {
        booksRepository.save(book);
    }
}
