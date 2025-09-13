package com.smartcurriculum.repository;

import com.smartcurriculum.entities.AttendanceRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// ===================== ATTENDANCE RECORD =====================
@Repository
public interface AttendanceRecordRepository extends MongoRepository<AttendanceRecord, String> {
    List<AttendanceRecord> findBySessionId(String sessionId);

    List<AttendanceRecord> findByStudentId(String studentId);

    Optional<AttendanceRecord> findBySessionIdAndStudentId(String sessionId, String studentId);
}
