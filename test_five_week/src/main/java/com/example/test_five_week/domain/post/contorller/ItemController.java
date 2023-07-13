package com.example.test_five_week.domain.post.contorller;

import com.example.test_five_week.domain.post.dto.ItemRequestDto;
import com.example.test_five_week.domain.post.dto.ItemResponseDto;
import com.example.test_five_week.domain.post.dto.ResultMsgDto;
import com.example.test_five_week.domain.post.entity.Item;
import com.example.test_five_week.domain.post.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/post")
    public ItemResponseDto write(@RequestBody ItemRequestDto itemRequestDto){
        Item newItem = itemService.write(itemRequestDto);

        return ItemResponseDto.of(newItem);
    }

    @GetMapping("/post")
    public List<ItemResponseDto> getAllItem(){
        List<Item> items = itemService.getAllItem();

        return items.stream().map(ItemResponseDto::of).toList();
    }

    @GetMapping("/post/{postId}")
    public ItemResponseDto getItem(@PathVariable(name = "postId") Long id){
        Item item = itemService.findItemBy(id);

        return ItemResponseDto.of(item);
    }

    @PutMapping("/post/{postId}")
    public ItemResponseDto updateItem(@PathVariable(name = "postId") Long id,
                                      @RequestBody ItemRequestDto itemRequestDto){
        Item updateItem = itemService.updateItemBy(id, itemRequestDto);

        return ItemResponseDto.of(updateItem);
    }

    @DeleteMapping("/post/{postId}")
    public ResultMsgDto deleteItem(@PathVariable(name = "postId") Long id){
        itemService.deleteItemBy(id);

        return new ResultMsgDto("삭제완료");
    }
}
