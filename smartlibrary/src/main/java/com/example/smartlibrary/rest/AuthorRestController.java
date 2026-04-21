package com.example.smartlibrary.rest;

import com.example.smartlibrary.dto.AuthorDto;
import com.example.smartlibrary.entity.Author;
import com.example.smartlibrary.mapper.AuthorMapper;
import com.example.smartlibrary.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorRestController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorMapper.toDtoList(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        return authorMapper.toDto(authorService.getAuthorById(id));
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        return authorMapper.toDto(authorService.createAuthor(author));
    }

    @PutMapping("/{id}")
    public AuthorDto updateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        return authorMapper.toDto(authorService.updateAuthor(id, author));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}