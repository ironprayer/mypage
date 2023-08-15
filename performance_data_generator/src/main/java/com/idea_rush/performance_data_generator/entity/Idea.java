package com.idea_rush.performance_data_generator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String category;

    @Column(length = 64, nullable = false)
    private String title;

    @Column(length = 1024, nullable = false)
    private String content;

    @Column(length = 64)
    private String imageName;

    @Column(nullable = false)
    private Long minimumStartingPrice;

    @Column
    private Long bidWinPrice;

    @Column(nullable = false)
    private LocalDateTime auctionStartTime;

    @Column(nullable = false)
    private LocalDateTime auctionEndTime;

    @Column(length = 8, nullable = false)
    private String auctionStatus;

    @Column(length = 16)
    private String dealStatus;

    private Long user_id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
