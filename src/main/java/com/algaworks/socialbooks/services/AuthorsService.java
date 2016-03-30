package com.algaworks.socialbooks.services;

import com.algaworks.socialbooks.domain.Author;
import com.algaworks.socialbooks.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;

    public List<Author> list() {
        return authorsRepository.findAll();
    }
}
