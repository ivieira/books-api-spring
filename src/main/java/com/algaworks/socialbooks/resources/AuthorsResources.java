package com.algaworks.socialbooks.resources;

import com.algaworks.socialbooks.domain.Author;
import com.algaworks.socialbooks.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsResources {

    @Autowired
    private AuthorsService authorsService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Author>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(authorsService.list());
    }
}
