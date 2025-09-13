package com.smartcurriculum.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

// ===================== ENROLLMENT =====================
@Document(collection = "enrollments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Enrollment {
    @Id
    private String id;
    private String sectionId;
    private String studentId;
    private LocalDateTime enrolledAt;
    private String status; // ACTIVE | DROPPED | COMPLETED
}