package com.example.smartlibrary.mapper;

import com.example.smartlibrary.dto.AuthorDto;
import com.example.smartlibrary.entity.Author;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-21T00:27:34+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDto toDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto.AuthorDtoBuilder authorDto = AuthorDto.builder();

        authorDto.id( author.getId() );
        authorDto.fullName( author.getFullName() );
        authorDto.country( author.getCountry() );

        return authorDto.build();
    }

    @Override
    public Author toEntity(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author.AuthorBuilder author = Author.builder();

        author.id( authorDto.getId() );
        author.fullName( authorDto.getFullName() );
        author.country( authorDto.getCountry() );

        return author.build();
    }

    @Override
    public List<AuthorDto> toDtoList(List<Author> authors) {
        if ( authors == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( authors.size() );
        for ( Author author : authors ) {
            list.add( toDto( author ) );
        }

        return list;
    }
}
