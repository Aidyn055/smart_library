package com.example.smartlibrary.mapper;

import com.example.smartlibrary.dto.BookDto;
import com.example.smartlibrary.entity.Book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.fullName", target = "authorFullName")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    BookDto toDto(Book book);

    List<BookDto> toDtoList(List<Book> books);
}
