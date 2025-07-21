package com.example.lostfound.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")  // This will be stored in MongoDB as "users" collection
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String identityProof; // File path or base64 encoded string
}
