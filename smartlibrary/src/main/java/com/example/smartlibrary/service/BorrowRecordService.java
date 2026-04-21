package com.example.smartlibrary.service;


import com.example.smartlibrary.entity.*;
import com.example.smartlibrary.exception.BusinessException;
import com.example.smartlibrary.exception.ResourceNotFoundException;
import com.example.smartlibrary.repository.BookRepository;
import com.example.smartlibrary.repository.BorrowRecordRepository;
import com.example.smartlibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowRecordService {
    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    public BorrowRecord getBorrowRecordById(Long id) {
        return borrowRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow record not found with id: " + id));
    }

    public BorrowRecord borrowBook(Long bookId, Long readerId) {
        try {
            Book book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

            Reader reader = readerRepository.findById(readerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Reader not found with id: " + readerId));

            if (book.getBookStatus() == BookStatus.BORROWED) {
                throw new BusinessException("Book is already borrowed");
            }

            BorrowRecord borrowRecord = BorrowRecord.builder()
                    .book(book)
                    .reader(reader)
                    .borrowDate(LocalDate.now())
                    .returnDate(null)
                    .borrowStatus(BorrowStatus.BORROWED)
                    .build();

            book.setBookStatus(BookStatus.BORROWED);

            borrowRecordRepository.save(borrowRecord);
            bookRepository.save(book);

            return borrowRecord;
        } catch (Exception e) {
            throw new RuntimeException("Error while borrowing book: " + e.getMessage());
        }
    }

    public BorrowRecord returnBook(Long borrowRecordId) {
        try {
            BorrowRecord borrowRecord = borrowRecordRepository.findById(borrowRecordId)
                    .orElseThrow(() -> new ResourceNotFoundException("Borrow record not found with id: " + borrowRecordId));

            if (borrowRecord.getBorrowStatus() == BorrowStatus.RETURNED) {
                throw new BusinessException("Book is already returned");
            }

            borrowRecord.setBorrowStatus(BorrowStatus.RETURNED);
            borrowRecord.setReturnDate(LocalDate.now());

            Book book = borrowRecord.getBook();
            book.setBookStatus(BookStatus.AVAILABLE);

            borrowRecordRepository.save(borrowRecord);
            bookRepository.save(book);

            return borrowRecord;
        } catch (Exception e) {
            throw new RuntimeException("Error while returning book: " + e.getMessage());
        }
    }

    public List<BorrowRecord> getBorrowRecordsByStatus(BorrowStatus borrowStatus) {
        return borrowRecordRepository.findByBorrowStatus(borrowStatus);
    }
    public List<BorrowRecord> getBorrowRecordsByBookId(Long bookId) {
        return borrowRecordRepository.findByBookId(bookId);
    }
    public List<BorrowRecord> getBorrowRecordsByReaderId(Long readerId) {
        return borrowRecordRepository.findByReaderId(readerId);
    }
}
