package com.example.smartlibrary.service;

import com.example.smartlibrary.entity.Author;
import com.example.smartlibrary.exception.ResourceNotFoundException;
import com.example.smartlibrary.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    public Author createAuthor(Author author) {
        try {
            return authorRepository.save(author);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating author: " + e.getMessage());
        }
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        try {
            Author existingAuthor = getAuthorById(id);

            existingAuthor.setFullName(updatedAuthor.getFullName());
            existingAuthor.setCountry(updatedAuthor.getCountry());

            return authorRepository.save(existingAuthor);
        } catch (Exception e) {
            throw new RuntimeException("Error while updating author: " + e.getMessage());
        }
    }

    public void deleteAuthor(Long id) {
        try {
            Author author = getAuthorById(id);
            authorRepository.delete(author);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting author: " + e.getMessage());
        }
    }
}
