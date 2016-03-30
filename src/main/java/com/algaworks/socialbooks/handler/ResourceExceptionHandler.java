package com.algaworks.socialbooks.handler;

import com.algaworks.socialbooks.domain.ErrorDetails;
import com.algaworks.socialbooks.services.exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBookNotFoundException(BookNotFoundException e, HttpServletRequest request) {

        ErrorDetails error =  new ErrorDetails();
        error.setStatus(404l);
        error.setTitle("The book cannot be found");
        error.setDeveloperMessage("http://errors.socialbooks.com/404");
        error.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
