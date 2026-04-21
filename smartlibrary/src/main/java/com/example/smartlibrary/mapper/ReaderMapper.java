package com.example.smartlibrary.mapper;

import com.example.smartlibrary.dto.ReaderDto;
import com.example.smartlibrary.entity.Reader;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReaderMapper {
    ReaderDto toDto(Reader reader);

    Reader toEntity(ReaderDto readerDto);

    List<ReaderDto> toDtoList(List<Reader> readers);
}
