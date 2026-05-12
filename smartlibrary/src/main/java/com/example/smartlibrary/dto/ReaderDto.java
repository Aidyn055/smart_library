package com.example.smartlibrary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReaderDto {
    private Long id;
    private String fullName;
    private String email;
}
