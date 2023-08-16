package com.idea_rush.performance_data_generator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String nickname;

    @Column(length = 16, nullable = false)
    private String userAccountId;

    @Column(length = 64, nullable = false)
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
