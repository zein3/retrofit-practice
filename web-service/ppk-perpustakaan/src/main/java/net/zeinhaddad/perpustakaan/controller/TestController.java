package net.zeinhaddad.perpustakaan.controller;

import org.springframework.web.bind.annotation.RestController;

import net.zeinhaddad.perpustakaan.entity.Book;
import net.zeinhaddad.perpustakaan.repository.BookRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    
}
