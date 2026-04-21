package com.example.smartlibrary.mapper;

import com.example.smartlibrary.dto.BorrowRecordDto;
import com.example.smartlibrary.entity.Book;
import com.example.smartlibrary.entity.BorrowRecord;
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
public class BorrowRecordMapperImpl implements BorrowRecordMapper {

    @Override
    public BorrowRecordDto toDto(BorrowRecord borrowRecord) {
        if ( borrowRecord == null ) {
            return null;
        }

        BorrowRecordDto.BorrowRecordDtoBuilder borrowRecordDto = BorrowRecordDto.builder();

        borrowRecordDto.bookId( borrowRecordBookId( borrowRecord ) );
        borrowRecordDto.bookTitle( borrowRecordBookTitle( borrowRecord ) );
        borrowRecordDto.readerId( borrowRecordReaderId( borrowRecord ) );
        borrowRecordDto.readerFullName( borrowRecordReaderFullName( borrowRecord ) );
        borrowRecordDto.id( borrowRecord.getId() );
        borrowRecordDto.borrowDate( borrowRecord.getBorrowDate() );
        borrowRecordDto.returnDate( borrowRecord.getReturnDate() );
        borrowRecordDto.borrowStatus( borrowRecord.getBorrowStatus() );

        return borrowRecordDto.build();
    }

    @Override
    public List<BorrowRecordDto> toDtoList(List<BorrowRecord> borrowRecords) {
        if ( borrowRecords == null ) {
            return null;
        }

        List<BorrowRecordDto> list = new ArrayList<BorrowRecordDto>( borrowRecords.size() );
        for ( BorrowRecord borrowRecord : borrowRecords ) {
            list.add( toDto( borrowRecord ) );
        }

        return list;
    }

    private Long borrowRecordBookId(BorrowRecord borrowRecord) {
        if ( borrowRecord == null ) {
            return null;
        }
        Book book = borrowRecord.getBook();
        if ( book == null ) {
            return null;
        }
        Long id = book.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String borrowRecordBookTitle(BorrowRecord borrowRecord) {
        if ( borrowRecord == null ) {
            return null;
        }
        Book book = borrowRecord.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private Long borrowRecordReaderId(BorrowRecord borrowRecord) {
        if ( borrowRecord == null ) {
            return null;
        }
        Reader reader = borrowRecord.getReader();
        if ( reader == null ) {
            return null;
        }
        Long id = reader.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String borrowRecordReaderFullName(BorrowRecord borrowRecord) {
        if ( borrowRecord == null ) {
            return null;
        }
        Reader reader = borrowRecord.getReader();
        if ( reader == null ) {
            return null;
        }
        String fullName = reader.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }
}
