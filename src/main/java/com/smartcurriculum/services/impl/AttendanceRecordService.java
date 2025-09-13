package com.smartcurriculum.services.impl;

import com.smartcurriculum.entities.AttendanceRecord;
import com.smartcurriculum.repository.AttendanceRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceRecordService implements com.smartcurriculum.services.AttendanceRecordService {

    private final AttendanceRecordRepository attendanceRecordRepository;

    @Override
    public AttendanceRecord saveRecord(AttendanceRecord record) {
        return attendanceRecordRepository.save(record);
    }

    @Override
    public Optional<AttendanceRecord> getRecordById(String id) {
        return attendanceRecordRepository.findById(id);
    }

    @Override
    public Optional<AttendanceRecord> getRecordBySessionAndStudent(String sessionId, String studentId) {
        return attendanceRecordRepository.findBySessionIdAndStudentId(sessionId, studentId);
    }

    @Override
    public List<AttendanceRecord> getRecordsBySessionId(String sessionId) {
        return attendanceRecordRepository.findBySessionId(sessionId);
    }

    @Override
    public List<AttendanceRecord> getRecordsByStudentId(String studentId) {
        return attendanceRecordRepository.findByStudentId(studentId);
    }

    @Override
    public List<AttendanceRecord> getAllRecords() {
        return attendanceRecordRepository.findAll();
    }

    @Override
    public void deleteRecord(String id) {
        attendanceRecordRepository.deleteById(id);
    }
}

