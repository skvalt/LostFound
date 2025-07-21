package com.example.lostfound.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "found_items")
public class FoundItem {
    @Id
    private String id;
    private String itemName;
    private String description;
    private String location;
    private String finderUserId; // The ID of the user who reported it as found
    private String uniqueIdentifier; // The identifier to match lost items
}
