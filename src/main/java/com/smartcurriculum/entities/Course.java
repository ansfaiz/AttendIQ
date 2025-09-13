package com.smartcurriculum.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// ===================== COURSE =====================
@Document(collection = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    private String id;
    private String code;
    private String name;
    private Integer credits;
    private String department;
    private String createdBy; // teacherId
    private Boolean active;
}