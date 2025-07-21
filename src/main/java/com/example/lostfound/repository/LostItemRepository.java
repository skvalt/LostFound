package com.example.lostfound.repository;

import com.example.lostfound.model.LostItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LostItemRepository extends MongoRepository<LostItem, String> {
    List<LostItem> findByLocation(String location);
}
