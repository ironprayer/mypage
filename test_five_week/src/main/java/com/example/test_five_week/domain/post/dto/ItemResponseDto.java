package com.example.test_five_week.domain.post.dto;

import com.example.test_five_week.domain.post.entity.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final int price;
    private final String username;

    public static ItemResponseDto of(Item item){
        return ItemResponseDto.builder()
                .id(item.getId())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .username(item.getUsername())
                .build();
    }
}
