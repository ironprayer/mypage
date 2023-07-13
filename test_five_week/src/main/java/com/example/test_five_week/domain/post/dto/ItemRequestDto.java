package com.example.test_five_week.domain.post.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ItemRequestDto {
    private final String title;
    private final String content;
    private final int price;
    private final String username;
}
