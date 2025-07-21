package com.example.lostfound.controller;

import com.example.lostfound.model.LostItem;
import com.example.lostfound.repository.LostItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lost-items")
public class LostItemController {
    @Autowired
    private LostItemRepository lostItemRepository;

    // API to report a lost item
    @PostMapping("/report")
    public ResponseEntity<?> reportLostItem(@RequestBody LostItem lostItem) {
        lostItemRepository.save(lostItem);
        return ResponseEntity.ok("Lost item reported successfully!");
    }

    // API to search lost items by location
    @GetMapping("/search")
    public ResponseEntity<List<LostItem>> searchLostItems(@RequestParam String location) {
        return ResponseEntity.ok(lostItemRepository.findByLocation(location));
    }
}
