package com.smartcurriculum.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// ===================== USER =====================
@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String id;
    private String role; // STUDENT | TEACHER | ADMIN | COUNSELOR
    private String username;
    private String name;
    private String email;
    private String passwordHash;
    private String phone;
    private String dept;
    private String rollNumber;
    private Integer year;
    private Integer semester;
    private List<String> interests;
    private List<Goal> goals;
    private List<DeviceBinding> devices;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Goal {
        private String id;
        private String title;
        private String category;
        private LocalDate targetDate;
        private Integer priority; // 1-5
        private String status; // ACTIVE | PAUSED | DONE
        private Integer progress; // 0-100
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeviceBinding {
        private String type; // BLUETOOTH | WIFI
        private String identifier; // hashed MAC/UUID
        private LocalDateTime verifiedAt;
    }
}

