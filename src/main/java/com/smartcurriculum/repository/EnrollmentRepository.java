package com.smartcurriculum.repository;

import com.smartcurriculum.entities.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// ===================== ENROLLMENT =====================
@Repository
public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
    List<Enrollment> findByStudentId(String studentId);

    List<Enrollment> findBySectionId(String sectionId);

    Optional<Enrollment> findBySectionIdAndStudentId(String sectionId, String studentId);
}
