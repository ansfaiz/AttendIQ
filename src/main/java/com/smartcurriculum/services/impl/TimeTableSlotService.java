package com.smartcurriculum.services.impl;


import com.smartcurriculum.entities.TimeTableSlot;
import com.smartcurriculum.repository.TimetableSlotRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeTableSlotService implements com.smartcurriculum.services.TimeTableSlotService {

    private final TimetableSlotRepository timetableSlotRepository;

    @Override
    public TimeTableSlot saveSlot(TimeTableSlot slot) {
        return timetableSlotRepository.save(slot);
    }

    @Override
    public Optional<TimeTableSlot> getSlotById(String id) {
        return timetableSlotRepository.findById(id);
    }

    @Override
    public List<TimeTableSlot> getSlotsBySectionId(String sectionId) {
        return timetableSlotRepository.findBySectionId(sectionId);
    }

    @Override
    public List<TimeTableSlot> getSlotsByDayOfWeek(Integer dayOfWeek) {
        return timetableSlotRepository.findByDayOfWeek(dayOfWeek);
    }

    @Override
    public List<TimeTableSlot> getAllSlots() {
        return timetableSlotRepository.findAll();
    }

    @Override
    public void deleteSlot(String id) {
        timetableSlotRepository.deleteById(id);
    }
}
