package com.example.smartlibrary.service;

import com.example.smartlibrary.entity.Reader;
import com.example.smartlibrary.exception.BusinessException;
import com.example.smartlibrary.exception.ResourceNotFoundException;
import com.example.smartlibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReaderById(Long id) {
        return readerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reader not found with id: " + id));
    }

    public Reader createReader(Reader reader) {
        try {
            if (readerRepository.findByEmail(reader.getEmail()).isPresent()) {
                throw new BusinessException("Reader with this email already exists");
            }

            return readerRepository.save(reader);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating reader: " + e.getMessage());
        }
    }

    public Reader updateReader(Long id, Reader updatedReader) {
        try {
            Reader existingReader = getReaderById(id);

            existingReader.setFullName(updatedReader.getFullName());
            existingReader.setEmail(updatedReader.getEmail());
            existingReader.setPhone(updatedReader.getPhone());

            return readerRepository.save(existingReader);
        } catch (Exception e) {
            throw new RuntimeException("Error while updating reader: " + e.getMessage());
        }
    }

    public void deleteReader(Long id) {
        try {
            Reader reader = getReaderById(id);
            readerRepository.delete(reader);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting reader: " + e.getMessage());
        }
    }
}
