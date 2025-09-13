package com.smartcurriculum.services.impl;

import com.smartcurriculum.entities.AttendanceSession;
import com.smartcurriculum.repository.AttendanceSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceSessionService implements com.smartcurriculum.services.AttendanceSessionService {

    private final AttendanceSessionRepository attendanceSessionRepository;

    @Override
    public AttendanceSession saveSession(AttendanceSession session) {
        return attendanceSessionRepository.save(session);
    }

    @Override
    public Optional<AttendanceSession> getSessionById(String id) {
        return attendanceSessionRepository.findById(id);
    }

    @Override
    public List<AttendanceSession> getSessionsBySectionId(String sectionId) {
        return attendanceSessionRepository.findBySectionId(sectionId);
    }

    @Override
    public List<AttendanceSession> getSessionsByDate(LocalDate date) {
        return attendanceSessionRepository.findByDate(date);
    }

    @Override
    public List<AttendanceSession> getSessionsByStatus(String status) {
        return attendanceSessionRepository.findByStatus(status);
    }

    @Override
    public List<AttendanceSession> getAllSessions() {
        return attendanceSessionRepository.findAll();
    }

    @Override
    public void deleteSession(String id) {
        attendanceSessionRepository.deleteById(id);
    }
}
