package net.zeinhaddad.perpustakaan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.zeinhaddad.perpustakaan.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrAuthorContainingOrDescriptionContaining(String title, String author, String description);
}
