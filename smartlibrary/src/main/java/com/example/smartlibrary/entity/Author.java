package com.example.smartlibrary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "author", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Book> books = new ArrayList<>();
}
