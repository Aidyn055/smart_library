package com.example.smartlibrary.mapper;

import com.example.smartlibrary.dto.BorrowRecordDto;
import com.example.smartlibrary.entity.BorrowRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BorrowRecordMapper {
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "reader.id", target = "readerId")
    @Mapping(source = "reader.fullName", target = "readerFullName")
    BorrowRecordDto toDto(BorrowRecord borrowRecord);

    List<BorrowRecordDto> toDtoList(List<BorrowRecord> borrowRecords);
}
