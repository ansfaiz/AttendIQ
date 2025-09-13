package com.smartcurriculum.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "attendanceSessions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceSession {
    @Id
    private String id;
    private String sectionId;
    private LocalDate date;
    private String slotId;
    private String method; // QR | PROXIMITY | FACE | MANUAL
    private String status; // OPEN | CLOSED
    private LocalDateTime opensAt;
    private LocalDateTime closesAt;
    private String qrToken;
    private String sessionCode;
    private String location; // optional
    private Integer presentCount;
}