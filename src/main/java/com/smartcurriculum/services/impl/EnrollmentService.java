package com.smartcurriculum.services.impl;
import com.smartcurriculum.entities.Enrollment;
import com.smartcurriculum.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService implements com.smartcurriculum.services.EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Optional<Enrollment> getEnrollmentById(String id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public Optional<Enrollment> getEnrollmentBySectionAndStudent(String sectionId, String studentId) {
        return enrollmentRepository.findBySectionIdAndStudentId(sectionId, studentId);
    }

    @Override
    public List<Enrollment> getEnrollmentsBySectionId(String sectionId) {
        return enrollmentRepository.findBySectionId(sectionId);
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudentId(String studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public void deleteEnrollment(String id) {
        enrollmentRepository.deleteById(id);
    }
}
