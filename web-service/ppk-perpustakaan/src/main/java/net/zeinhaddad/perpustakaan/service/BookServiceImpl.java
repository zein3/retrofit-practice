package net.zeinhaddad.perpustakaan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zeinhaddad.perpustakaan.dto.BookDto;
import net.zeinhaddad.perpustakaan.entity.Book;
import net.zeinhaddad.perpustakaan.mapper.BookMapper;
import net.zeinhaddad.perpustakaan.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void createBook(BookDto bookDto) {
        bookRepository.save(BookMapper.mapToBook(bookDto));
    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = books.stream()
            .map((book) -> (BookMapper.mapToDto(book)))
            .collect(Collectors.toList());
        
        return bookDtos;
    }

    @Override
    public List<BookDto> searchBooks(String query) {
        List<Book> books = bookRepository.findByTitleContainingOrAuthorContainingOrDescriptionContaining(query, query, query);
        List<BookDto> bookDtos = books.stream()
            .map((book) -> (BookMapper.mapToDto(book)))
            .collect(Collectors.toList());

        return bookDtos;
    }
    
}
