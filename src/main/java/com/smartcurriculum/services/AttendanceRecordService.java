package com.smartcurriculum.services;

import com.smartcurriculum.entities.AttendanceRecord;

import java.util.List;
import java.util.Optional;

public interface AttendanceRecordService {
    AttendanceRecord saveRecord(AttendanceRecord record);
    Optional<AttendanceRecord> getRecordById(String id);
    Optional<AttendanceRecord> getRecordBySessionAndStudent(String sessionId, String studentId);
    List<AttendanceRecord> getRecordsBySessionId(String sessionId);
    List<AttendanceRecord> getRecordsByStudentId(String studentId);
    List<AttendanceRecord> getAllRecords();
    void deleteRecord(String id);
}
