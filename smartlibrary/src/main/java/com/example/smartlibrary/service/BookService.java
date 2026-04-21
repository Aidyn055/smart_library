package com.example.smartlibrary.service;

import com.example.smartlibrary.entity.Author;
import com.example.smartlibrary.entity.Book;
import com.example.smartlibrary.entity.BookStatus;
import com.example.smartlibrary.entity.Category;
import com.example.smartlibrary.exception.ResourceNotFoundException;
import com.example.smartlibrary.repository.AuthorRepository;
import com.example.smartlibrary.repository.BookRepository;
import com.example.smartlibrary.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    public Book createBook(Book book, Long authorId, Long categoryId) {
        try {
            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));

            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

            book.setAuthor(author);
            book.setCategory(category);

            if (book.getBookStatus() == null) {
                book.setBookStatus(BookStatus.AVAILABLE);
            }

            return bookRepository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating book: " + e.getMessage());
        }
    }

    public Book updateBook(Long id, Book updatedBook, Long authorId, Long categoryId) {
        try {
            Book existingBook = getBookById(id);

            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));

            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setPublishedYear(updatedBook.getPublishedYear());
            existingBook.setQuantity(updatedBook.getQuantity());
            existingBook.setBookStatus(updatedBook.getBookStatus());
            existingBook.setAuthor(author);
            existingBook.setCategory(category);

            return bookRepository.save(existingBook);
        } catch (Exception e) {
            throw new RuntimeException("Error while updating book: " + e.getMessage());
        }
    }

    public void deleteBook(Long id) {
        try {
            Book book = getBookById(id);
            bookRepository.delete(book);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting book: " + e.getMessage());
        }
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> getBooksByCategory(Long categoryId) {
        return bookRepository.findByCategoryId(categoryId);
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public List<Book> getBooksByStatus(BookStatus bookStatus) {
        return bookRepository.findByBookStatus(bookStatus);
    }
}
