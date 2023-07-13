package com.example.test_five_week.domain.post.entity;

import com.example.test_five_week.domain.post.dto.ItemRequestDto;
import com.example.test_five_week.domain.post.repository.ItemRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public static Item of(ItemRequestDto itemRequestDto){
        return Item.builder()
                .title(itemRequestDto.getTitle())
                .content(itemRequestDto.getContent())
                .price(itemRequestDto.getPrice())
                .username(itemRequestDto.getUsername())
                .build();

    }

    public void changeOf(ItemRequestDto itemRequestDto){
        this.title = itemRequestDto.getTitle();
        this.content = itemRequestDto.getContent();
        this.price = itemRequestDto.getPrice();
        this.username = itemRequestDto.getUsername();
    }
}
