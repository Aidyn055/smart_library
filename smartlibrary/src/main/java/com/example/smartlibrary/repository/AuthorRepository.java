package com.example.smartlibrary.repository;

import com.example.smartlibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
