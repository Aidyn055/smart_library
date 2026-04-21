package com.example.smartlibrary.rest;

import com.example.smartlibrary.dto.BookDto;
import com.example.smartlibrary.entity.Book;
import com.example.smartlibrary.entity.BookStatus;
import com.example.smartlibrary.mapper.BookMapper;
import com.example.smartlibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookMapper.toDtoList(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookMapper.toDto(bookService.getBookById(id));
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .description(bookDto.getDescription())
                .isbn(bookDto.getIsbn())
                .publishedYear(bookDto.getPublishedYear())
                .quantity(bookDto.getQuantity())
                .bookStatus(bookDto.getBookStatus())
                .build();

        return bookMapper.toDto(
                bookService.createBook(book, bookDto.getAuthorId(), bookDto.getCategoryId())
        );
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .description(bookDto.getDescription())
                .isbn(bookDto.getIsbn())
                .publishedYear(bookDto.getPublishedYear())
                .quantity(bookDto.getQuantity())
                .bookStatus(bookDto.getBookStatus())
                .build();

        return bookMapper.toDto(
                bookService.updateBook(id, book, bookDto.getAuthorId(), bookDto.getCategoryId())
        );
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<BookDto> searchBooks(@RequestParam String title) {
        return bookMapper.toDtoList(bookService.searchBooksByTitle(title));
    }

    @GetMapping("/category/{categoryId}")
    public List<BookDto> getBooksByCategory(@PathVariable Long categoryId) {
        return bookMapper.toDtoList(bookService.getBooksByCategory(categoryId));
    }

    @GetMapping("/author/{authorId}")
    public List<BookDto> getBooksByAuthor(@PathVariable Long authorId) {
        return bookMapper.toDtoList(bookService.getBooksByAuthor(authorId));
    }

    @GetMapping("/status")
    public List<BookDto> getBooksByStatus(@RequestParam BookStatus bookStatus) {
        return bookMapper.toDtoList(bookService.getBooksByStatus(bookStatus));
    }
}