package com.example.lostfound.controller;

import com.example.lostfound.model.LostItem;
import com.example.lostfound.model.FoundItem;
import com.example.lostfound.repository.LostItemRepository;
import com.example.lostfound.repository.FoundItemRepository;
import com.example.lostfound.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/match")
public class MatchingController {
    @Autowired
    private LostItemRepository lostItemRepository;

    @Autowired
    private FoundItemRepository foundItemRepository;

    @Autowired
    private EmailService emailService; // Inject Email Service

    @GetMapping("/find")
    public ResponseEntity<?> findMatchingItems(@RequestParam String foundItemId) {
        Optional<FoundItem> foundItemOpt = foundItemRepository.findById(foundItemId);
        if (foundItemOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: Found item ID does not exist!");
        }

        FoundItem foundItem = foundItemOpt.get();
        List<LostItem> matchingItems = lostItemRepository.findAll().stream()
                .filter(lostItem -> lostItem.getItemName().equalsIgnoreCase(foundItem.getItemName())
                        && lostItem.getUniqueIdentifier().equalsIgnoreCase(foundItem.getUniqueIdentifier()))
                .collect(Collectors.toList());

        if (!matchingItems.isEmpty()) {
            for (LostItem lostItem : matchingItems) {
                // Send Email Notification
                String emailBody = "Your lost item '" + lostItem.getItemName() + "' has been found at " +
                        foundItem.getLocation() + ". Please contact support to claim it.";
                emailService.sendEmail("skphotos1603@gmail.com", "Lost Item Found!", emailBody);
            }
            return ResponseEntity.ok("Matching items found! Email notifications sent.");
        }

        return ResponseEntity.ok("No matching lost items found.");
    }
}
