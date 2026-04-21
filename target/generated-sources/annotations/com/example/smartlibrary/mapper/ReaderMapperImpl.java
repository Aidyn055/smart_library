package com.example.smartlibrary.mapper;

import com.example.smartlibrary.dto.ReaderDto;
import com.example.smartlibrary.entity.Reader;
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
public class ReaderMapperImpl implements ReaderMapper {

    @Override
    public ReaderDto toDto(Reader reader) {
        if ( reader == null ) {
            return null;
        }

        ReaderDto.ReaderDtoBuilder readerDto = ReaderDto.builder();

        readerDto.id( reader.getId() );
        readerDto.fullName( reader.getFullName() );
        readerDto.email( reader.getEmail() );
        readerDto.phone( reader.getPhone() );

        return readerDto.build();
    }

    @Override
    public Reader toEntity(ReaderDto readerDto) {
        if ( readerDto == null ) {
            return null;
        }

        Reader.ReaderBuilder reader = Reader.builder();

        reader.id( readerDto.getId() );
        reader.fullName( readerDto.getFullName() );
        reader.email( readerDto.getEmail() );
        reader.phone( readerDto.getPhone() );

        return reader.build();
    }

    @Override
    public List<ReaderDto> toDtoList(List<Reader> readers) {
        if ( readers == null ) {
            return null;
        }

        List<ReaderDto> list = new ArrayList<ReaderDto>( readers.size() );
        for ( Reader reader : readers ) {
            list.add( toDto( reader ) );
        }

        return list;
    }
}
