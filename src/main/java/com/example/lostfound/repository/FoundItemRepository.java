package com.example.lostfound.repository;

import com.example.lostfound.model.FoundItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoundItemRepository extends MongoRepository<FoundItem, String> {
    List<FoundItem> findByLocation(String location);
}
