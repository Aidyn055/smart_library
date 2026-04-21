package com.example.smartlibrary.mapper;

import com.example.smartlibrary.dto.BookDto;
import com.example.smartlibrary.entity.Author;
import com.example.smartlibrary.entity.Book;
import com.example.smartlibrary.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-21T00:27:33+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto.BookDtoBuilder bookDto = BookDto.builder();

        bookDto.authorId( bookAuthorId( book ) );
        bookDto.authorFullName( bookAuthorFullName( book ) );
        bookDto.categoryId( bookCategoryId( book ) );
        bookDto.categoryName( bookCategoryName( book ) );
        bookDto.id( book.getId() );
        bookDto.title( book.getTitle() );
        bookDto.description( book.getDescription() );
        bookDto.isbn( book.getIsbn() );
        bookDto.publishedYear( book.getPublishedYear() );
        bookDto.quantity( book.getQuantity() );
        bookDto.bookStatus( book.getBookStatus() );

        return bookDto.build();
    }

    @Override
    public List<BookDto> toDtoList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( books.size() );
        for ( Book book : books ) {
            list.add( toDto( book ) );
        }

        return list;
    }

    private Long bookAuthorId(Book book) {
        if ( book == null ) {
            return null;
        }
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        Long id = author.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String bookAuthorFullName(Book book) {
        if ( book == null ) {
            return null;
        }
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        String fullName = author.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }

    private Long bookCategoryId(Book book) {
        if ( book == null ) {
            return null;
        }
        Category category = book.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String bookCategoryName(Book book) {
        if ( book == null ) {
            return null;
        }
        Category category = book.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
