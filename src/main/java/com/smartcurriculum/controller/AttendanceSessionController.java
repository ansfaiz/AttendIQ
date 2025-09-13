package com.smartcurriculum.controller;

import com.smartcurriculum.entities.AttendanceSession;
import com.smartcurriculum.services.AttendanceSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance-sessions")
@RequiredArgsConstructor
public class AttendanceSessionController {

    private final AttendanceSessionService attendanceSessionService;

    // ➡️ Create a new session
    @PostMapping
    public ResponseEntity<AttendanceSession> createSession(@RequestBody AttendanceSession session) {
        return ResponseEntity.ok(attendanceSessionService.saveSession(session));
    }

    // ➡️ Get session by ID
    @GetMapping("/{id}")
    public ResponseEntity<AttendanceSession> getSessionById(@PathVariable String id) {
        Optional<AttendanceSession> session = attendanceSessionService.getSessionById(id);
        return session.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➡️ Get sessions by sectionId
    @GetMapping("/section/{sectionId}")
    public ResponseEntity<List<AttendanceSession>> getSessionsBySectionId(@PathVariable String sectionId) {
        return ResponseEntity.ok(attendanceSessionService.getSessionsBySectionId(sectionId));
    }

    // ➡️ Get sessions by date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<AttendanceSession>> getSessionsByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(attendanceSessionService.getSessionsByDate(date));
    }

    // ➡️ Get sessions by status (e.g., "ACTIVE", "CLOSED")
    @GetMapping("/status/{status}")
    public ResponseEntity<List<AttendanceSession>> getSessionsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(attendanceSessionService.getSessionsByStatus(status));
    }

    // ➡️ Get all sessions
    @GetMapping
    public ResponseEntity<List<AttendanceSession>> getAllSessions() {
        return ResponseEntity.ok(attendanceSessionService.getAllSessions());
    }

    // ➡️ Delete session
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable String id) {
        attendanceSessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}
