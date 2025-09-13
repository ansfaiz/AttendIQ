package com.smartcurriculum.repository;

import com.smartcurriculum.entities.TimeTableSlot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// ===================== TIMETABLE SLOT =====================
@Repository
public interface TimetableSlotRepository extends MongoRepository<TimeTableSlot, String> {
    List<TimeTableSlot> findBySectionId(String sectionId);

    List<TimeTableSlot> findByDayOfWeek(Integer dayOfWeek);
}
