package com.smartcurriculum.services;

import com.smartcurriculum.entities.AttendanceSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceSessionService {
    AttendanceSession saveSession(AttendanceSession session);
    Optional<AttendanceSession> getSessionById(String id);
    List<AttendanceSession> getSessionsBySectionId(String sectionId);
    List<AttendanceSession> getSessionsByDate(LocalDate date);
    List<AttendanceSession> getSessionsByStatus(String status);
    List<AttendanceSession> getAllSessions();
    void deleteSession(String id);
}
