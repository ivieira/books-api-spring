package com.algaworks.socialbooks.resources;

import com.algaworks.socialbooks.domain.Book;
import com.algaworks.socialbooks.services.BooksService;
import com.algaworks.socialbooks.services.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksResources {

    @Autowired
    private BooksService booksService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(booksService.list());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Book book) {
        book = booksService.save(book);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable("id") Long id) {
        Book book;
        try {
            book = booksService.find(id);
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            booksService.delete(id);
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Book book, @PathVariable("id") Long id) {
        book.setId(id);
        try {
            booksService.update(book);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
