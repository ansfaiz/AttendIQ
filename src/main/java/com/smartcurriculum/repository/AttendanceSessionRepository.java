package com.smartcurriculum.repository;

import com.smartcurriculum.entities.AttendanceSession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

// ===================== ATTENDANCE SESSION =====================
@Repository
public interface AttendanceSessionRepository extends MongoRepository<AttendanceSession, String> {
    List<AttendanceSession> findBySectionId(String sectionId);

    List<AttendanceSession> findByDate(LocalDate date);

    List<AttendanceSession> findByStatus(String status);
}
