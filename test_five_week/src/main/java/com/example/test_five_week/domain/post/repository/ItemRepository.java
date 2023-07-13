package com.example.test_five_week.domain.post.repository;

import com.example.test_five_week.domain.post.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
