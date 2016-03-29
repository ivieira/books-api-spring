package com.algaworks.socialbooks.resources;

import com.algaworks.socialbooks.domain.Book;
import com.algaworks.socialbooks.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book find(@PathVariable("id") Long id) {
        return booksRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        booksRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Book book, @PathVariable("id") Long id) {
        book.setId(id);
        booksRepository.save(book);
    }
}
