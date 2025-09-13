package com.smartcurriculum.services;


import com.smartcurriculum.entities.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    Enrollment saveEnrollment(Enrollment enrollment);
    Optional<Enrollment> getEnrollmentById(String id);
    Optional<Enrollment> getEnrollmentBySectionAndStudent(String sectionId, String studentId);
    List<Enrollment> getEnrollmentsBySectionId(String sectionId);
    List<Enrollment> getEnrollmentsByStudentId(String studentId);
    List<Enrollment> getAllEnrollments();
    void deleteEnrollment(String id);
}
