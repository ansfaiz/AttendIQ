package com.smartcurriculum.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// ===================== SECTION =====================
@Document(collection = "sections")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Section {
    @Id
    private String id;
    private String courseId;
    private String teacherId;
    private String term; // e.g., 2025-ODD
    private String roomId;
    private Integer studentCount;
}