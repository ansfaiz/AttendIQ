package com.smartcurriculum.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// ===================== TIMETABLE SLOT =====================
@Document(collection = "timetableSlots")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeTableSlot {
    @Id
    private String id;
    private String sectionId;
    private Integer dayOfWeek; // 1=Mon ... 7=Sun
    private String startTime; // HH:mm
    private String endTime;   // HH:mm
    private String roomId;
}

