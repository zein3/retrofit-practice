package net.zeinhaddad.perpustakaan.service;

import java.util.List;

import net.zeinhaddad.perpustakaan.dto.BookDto;

public interface BookService {
    public void createBook(BookDto bookDto);
    public List<BookDto> getBooks();
    public List<BookDto> searchBooks(String query);
}
