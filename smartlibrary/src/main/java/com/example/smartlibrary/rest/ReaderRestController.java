package com.example.smartlibrary.rest;

import com.example.smartlibrary.dto.ReaderDto;
import com.example.smartlibrary.entity.Reader;
import com.example.smartlibrary.mapper.ReaderMapper;
import com.example.smartlibrary.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
@RequiredArgsConstructor
public class ReaderRestController {

    private final ReaderService readerService;
    private final ReaderMapper readerMapper;

    @GetMapping
    public List<ReaderDto> getAllReaders() {
        return readerMapper.toDtoList(readerService.getAllReaders());
    }

    @GetMapping("/{id}")
    public ReaderDto getReaderById(@PathVariable Long id) {
        return readerMapper.toDto(readerService.getReaderById(id));
    }

    @PostMapping
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.toEntity(readerDto);
        return readerMapper.toDto(readerService.createReader(reader));
    }

    @PutMapping("/{id}")
    public ReaderDto updateReader(@PathVariable Long id, @RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.toEntity(readerDto);
        return readerMapper.toDto(readerService.updateReader(id, reader));
    }

    @DeleteMapping("/{id}")
    public void deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
    }
}