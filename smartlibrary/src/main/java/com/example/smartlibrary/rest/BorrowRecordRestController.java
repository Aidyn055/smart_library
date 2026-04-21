package com.example.smartlibrary.rest;

import com.example.smartlibrary.dto.BorrowRecordDto;
import com.example.smartlibrary.entity.BorrowRecord;
import com.example.smartlibrary.entity.BorrowStatus;
import com.example.smartlibrary.mapper.BorrowRecordMapper;
import com.example.smartlibrary.service.BorrowRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow-records")
@RequiredArgsConstructor
public class BorrowRecordRestController {

    private final BorrowRecordService borrowRecordService;
    private final BorrowRecordMapper borrowRecordMapper;

    @GetMapping
    public List<BorrowRecordDto> getAllBorrowRecords() {
        return borrowRecordMapper.toDtoList(borrowRecordService.getAllBorrowRecords());
    }

    @GetMapping("/{id}")
    public BorrowRecordDto getBorrowRecordById(@PathVariable Long id) {
        return borrowRecordMapper.toDto(borrowRecordService.getBorrowRecordById(id));
    }

    @PostMapping("/borrow")
    public BorrowRecordDto borrowBook(@RequestParam Long bookId, @RequestParam Long readerId) {
        BorrowRecord borrowRecord = borrowRecordService.borrowBook(bookId, readerId);
        return borrowRecordMapper.toDto(borrowRecord);
    }

    @PostMapping("/return/{id}")
    public BorrowRecordDto returnBook(@PathVariable Long id) {
        BorrowRecord borrowRecord = borrowRecordService.returnBook(id);
        return borrowRecordMapper.toDto(borrowRecord);
    }

    @GetMapping("/status")
    public List<BorrowRecordDto> getBorrowRecordsByStatus(@RequestParam BorrowStatus borrowStatus) {
        return borrowRecordMapper.toDtoList(
                borrowRecordService.getBorrowRecordsByStatus(borrowStatus)
        );
    }

    @GetMapping("/book/{bookId}")
    public List<BorrowRecordDto> getBorrowRecordsByBookId(@PathVariable Long bookId) {
        return borrowRecordMapper.toDtoList(
                borrowRecordService.getBorrowRecordsByBookId(bookId)
        );
    }

    @GetMapping("/reader/{readerId}")
    public List<BorrowRecordDto> getBorrowRecordsByReaderId(@PathVariable Long readerId) {
        return borrowRecordMapper.toDtoList(
                borrowRecordService.getBorrowRecordsByReaderId(readerId)
        );
    }
}