package com.smartcurriculum.controller;

import com.smartcurriculum.entities.AttendanceRecord;
import com.smartcurriculum.services.AttendanceRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance-records")
@RequiredArgsConstructor
public class AttendanceRecordController {

    private final AttendanceRecordService attendanceRecordService;

    // ➡️ Create attendance record
    @PostMapping
    public ResponseEntity<AttendanceRecord> createRecord(@RequestBody AttendanceRecord record) {
        return ResponseEntity.ok(attendanceRecordService.saveRecord(record));
    }

    // ➡️ Get attendance record by ID
    @GetMapping("/{id}")
    public ResponseEntity<AttendanceRecord> getRecordById(@PathVariable String id) {
        Optional<AttendanceRecord> record = attendanceRecordService.getRecordById(id);
        return record.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➡️ Get record by session + student
    @GetMapping("/session/{sessionId}/student/{studentId}")
    public ResponseEntity<AttendanceRecord> getRecordBySessionAndStudent(
            @PathVariable String sessionId,
            @PathVariable String studentId) {
        Optional<AttendanceRecord> record = attendanceRecordService.getRecordBySessionAndStudent(sessionId, studentId);
        return record.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➡️ Get records by session
    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<AttendanceRecord>> getRecordsBySessionId(@PathVariable String sessionId) {
        return ResponseEntity.ok(attendanceRecordService.getRecordsBySessionId(sessionId));
    }

    // ➡️ Get records by student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AttendanceRecord>> getRecordsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(attendanceRecordService.getRecordsByStudentId(studentId));
    }

    // ➡️ Get all records
    @GetMapping
    public ResponseEntity<List<AttendanceRecord>> getAllRecords() {
        return ResponseEntity.ok(attendanceRecordService.getAllRecords());
    }

    // ➡️ Delete attendance record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable String id) {
        attendanceRecordService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}

