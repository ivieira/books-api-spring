package com.algaworks.socialbooks.services;

import com.algaworks.socialbooks.domain.Book;
import com.algaworks.socialbooks.domain.Review;
import com.algaworks.socialbooks.repository.BooksRepository;
import com.algaworks.socialbooks.repository.ReviewsRepository;
import com.algaworks.socialbooks.services.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private ReviewsRepository reviewsRepository;

    public List<Book> list() {
        return booksRepository.findAll();
    }

    public Book find(Long id) {
        Book book = booksRepository.findOne(id);
        if (book == null) {
            throw new BookNotFoundException("The book cannot be found.");
        }
        return book;
    }

    public Book save(Book book) {
        book.setId(null);
        return booksRepository.save(book);
    }

    public void delete(Long id) {
        try {
            booksRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new BookNotFoundException("The book cannot be found");
        }
    }

    public void update(Book book) {
        exists(book);
        booksRepository.save(book);
    }

    public Review saveReview(Long bookId, Review review) {
        Book book = find(bookId);

        review.setId(null);
        review.setBook(book);
        review.setDate(new Date());

        return reviewsRepository.save(review);
    }

    public List<Review> listReviews(Long bookId) {
        Book book = find(bookId);
        return book.getReviews();
    }

    private void exists(Book book) {
        find(book.getId());
    }
}
