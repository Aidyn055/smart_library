package com.example.smartlibrary.repository;

import com.example.smartlibrary.entity.BorrowRecord;
import com.example.smartlibrary.entity.BorrowStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {

    List<BorrowRecord> findByBorrowStatus(BorrowStatus borrowStatus);
    List<BorrowRecord>findByBookId(Long bookId);
    List<BorrowRecord> findByReaderId(Long readerId);
}
