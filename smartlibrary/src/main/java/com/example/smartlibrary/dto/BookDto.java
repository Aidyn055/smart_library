package com.example.smartlibrary.dto;

import com.example.smartlibrary.entity.BookStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String description;
    private String isbn;
    private int publishedYear;
    private int quantity;
    private BookStatus bookStatus;

    private Long authorId;
    private String authorFullName;

    private Long categoryId;
    private String categoryName;
}
