package com.example.smartlibrary.dto;

import com.example.smartlibrary.entity.BorrowStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowRecordDto {
    private Long id;

    private Long bookId;
    private String bookTitle;

    private Long readerId;
    private String readerFullName;

    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BorrowStatus borrowStatus;
}
