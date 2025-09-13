package com.smartcurriculum.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

// ===================== ATTENDANCE RECORD =====================
@Document(collection = "attendanceRecords")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceRecord {
    @Id
    private String id;
    private String sessionId;
    private String studentId;
    private String status; // PRESENT | ABSENT | LATE | EXCUSED
    private LocalDateTime markedAt;
    private String method; // QR | PROXIMITY | FACE | MANUAL
}
