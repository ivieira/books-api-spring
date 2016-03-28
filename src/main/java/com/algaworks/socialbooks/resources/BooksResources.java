package com.algaworks.socialbooks.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksResources {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list() {
        return "Rest Aplicado, Git passo-a-passo";
    }
}
