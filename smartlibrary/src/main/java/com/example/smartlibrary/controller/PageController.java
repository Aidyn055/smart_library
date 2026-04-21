package com.example.smartlibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/books")
    public String booksPage() {
        return "books";
    }

    @GetMapping("/authors")
    public String authorsPage() {
        return "authors";
    }

    @GetMapping("/categories")
    public String categoriesPage() {
        return "categories";
    }

    @GetMapping("/readers")
    public String readersPage() {
        return "readers";
    }

    @GetMapping("/borrow-records")
    public String borrowRecordsPage() {
        return "borrow-records";
    }
}