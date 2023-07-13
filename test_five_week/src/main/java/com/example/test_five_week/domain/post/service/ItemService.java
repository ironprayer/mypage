package com.example.test_five_week.domain.post.service;

import com.example.test_five_week.domain.post.dto.ItemRequestDto;
import com.example.test_five_week.domain.post.entity.Item;
import com.example.test_five_week.domain.post.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item write(ItemRequestDto itemRequestDto){
        return itemRepository.save(Item.of(itemRequestDto));
    }

    @Transactional(readOnly = true)
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Item findItemBy(Long id) {
        return itemRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("아이템이 존재하지 않습니다."));
    }

    @Transactional
    public Item updateItemBy(Long id, ItemRequestDto itemRequestDto) {
        Item findItem = itemRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("아이템이 존재하지 않습니다."));

        findItem.changeOf(itemRequestDto);
        return findItem;
    }

    public void deleteItemBy(Long id) {
        Item findItem = itemRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("아이템이 존재하지 않습니다."));

        itemRepository.delete(findItem);
    }
}
