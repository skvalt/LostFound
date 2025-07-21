package com.example.lostfound.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "lost_items")
public class LostItem {
    @Id
    private String id;
    private String itemName;
    private String description;
    private String location;
    private String userId;  // The ID of the user who reported it
    private String uniqueIdentifier; // Something unique to verify the item
}
