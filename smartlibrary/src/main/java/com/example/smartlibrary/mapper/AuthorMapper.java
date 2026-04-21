package com.example.smartlibrary.mapper;

import com.example.smartlibrary.dto.AuthorDto;
import com.example.smartlibrary.entity.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toDto(Author author);
    Author toEntity(AuthorDto authorDto);
    List<AuthorDto> toDtoList(List<Author> authors);
}
