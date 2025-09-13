package com.smartcurriculum.services;

import com.smartcurriculum.entities.TimeTableSlot;

import java.util.List;
import java.util.Optional;

public interface TimeTableSlotService {
    TimeTableSlot saveSlot(TimeTableSlot slot);
    Optional<TimeTableSlot> getSlotById(String id);
    List<TimeTableSlot> getSlotsBySectionId(String sectionId);
    List<TimeTableSlot> getSlotsByDayOfWeek(Integer dayOfWeek);
    List<TimeTableSlot> getAllSlots();
    void deleteSlot(String id);
}

