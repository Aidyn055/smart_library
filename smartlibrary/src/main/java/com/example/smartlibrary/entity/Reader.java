package com.example.smartlibrary.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "readers")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
