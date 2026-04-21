package com.example.smartlibrary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String fullName;
    private String country;
}
