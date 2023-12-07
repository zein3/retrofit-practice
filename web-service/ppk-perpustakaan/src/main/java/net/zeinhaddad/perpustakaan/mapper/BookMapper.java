package net.zeinhaddad.perpustakaan.mapper;

import net.zeinhaddad.perpustakaan.dto.BookDto;
import net.zeinhaddad.perpustakaan.entity.Book;

public class BookMapper {
    public static Book mapToBook(BookDto bookDto) {
        return Book.builder()
            .id(bookDto.getId())
            .title(bookDto.getTitle())
            .author(bookDto.getAuthor())
            .description(bookDto.getDescription())
            .build();
    }

    public static BookDto mapToDto(Book book) {
        return BookDto.builder()
            .id(book.getId())
            .title(book.getTitle())
            .author(book.getAuthor())
            .description(book.getDescription())
            .build();
    }
}
