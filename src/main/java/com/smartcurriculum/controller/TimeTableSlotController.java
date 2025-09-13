package com.smartcurriculum.controller;

import com.smartcurriculum.entities.TimeTableSlot;
import com.smartcurriculum.services.TimeTableSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/timetable-slots")
@RequiredArgsConstructor
public class TimeTableSlotController {

    private final TimeTableSlotService timeTableSlotService;

    // ➡️ Create timetable slot
    @PostMapping
    public ResponseEntity<TimeTableSlot> createSlot(@RequestBody TimeTableSlot slot) {
        return ResponseEntity.ok(timeTableSlotService.saveSlot(slot));
    }

    // ➡️ Get timetable slot by ID
    @GetMapping("/{id}")
    public ResponseEntity<TimeTableSlot> getSlotById(@PathVariable String id) {
        Optional<TimeTableSlot> slot = timeTableSlotService.getSlotById(id);
        return slot.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➡️ Get all timetable slots
    @GetMapping
    public ResponseEntity<List<TimeTableSlot>> getAllSlots() {
        return ResponseEntity.ok(timeTableSlotService.getAllSlots());
    }

    // ➡️ Get slots by sectionId
    @GetMapping("/section/{sectionId}")
    public ResponseEntity<List<TimeTableSlot>> getSlotsBySectionId(@PathVariable String sectionId) {
        return ResponseEntity.ok(timeTableSlotService.getSlotsBySectionId(sectionId));
    }

    // ➡️ Get slots by day of week
    @GetMapping("/day/{dayOfWeek}")
    public ResponseEntity<List<TimeTableSlot>> getSlotsByDayOfWeek(@PathVariable Integer dayOfWeek) {
        return ResponseEntity.ok(timeTableSlotService.getSlotsByDayOfWeek(dayOfWeek));
    }

    // ➡️ Update timetable slot
    @PutMapping("/{id}")
    public ResponseEntity<TimeTableSlot> updateSlot(@PathVariable String id, @RequestBody TimeTableSlot updatedSlot) {
        return timeTableSlotService.getSlotById(id).map(slot -> {
            updatedSlot.setId(slot.getId()); // preserve id
            return ResponseEntity.ok(timeTableSlotService.saveSlot(updatedSlot));
        }).orElse(ResponseEntity.notFound().build());
    }

    // ➡️ Delete timetable slot
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSlot(@PathVariable String id) {
        timeTableSlotService.deleteSlot(id);
        return ResponseEntity.noContent().build();
    }
}
