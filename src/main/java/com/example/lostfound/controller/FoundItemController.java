package com.example.lostfound.controller;

import com.example.lostfound.model.FoundItem;
import com.example.lostfound.repository.FoundItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/found-items")
public class FoundItemController {
    @Autowired
    private FoundItemRepository foundItemRepository;

    // API to report a found item
    @PostMapping("/report")
    public ResponseEntity<?> reportFoundItem(@RequestBody FoundItem foundItem) {
        foundItemRepository.save(foundItem);
        return ResponseEntity.ok("Found item reported successfully!");
    }

    // API to search found items by location
    @GetMapping("/search")
    public ResponseEntity<List<FoundItem>> searchFoundItems(@RequestParam String location) {
        return ResponseEntity.ok(foundItemRepository.findByLocation(location));
    }
}
