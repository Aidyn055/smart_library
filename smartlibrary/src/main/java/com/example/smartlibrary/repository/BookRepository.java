package com.example.smartlibrary.repository;

import com.example.smartlibrary.entity.Book;
import com.example.smartlibrary.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByAuthorId(Long authorId);

    List<Book> findByBookStatus(BookStatus bookStatus);

}
