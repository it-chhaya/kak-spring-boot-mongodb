package com.devkh.mongodb;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("courses")
public class Course {
    @Id
    private String id;
    private String title;
    private String description;
    private Float rate;
    private String feedback;
}
