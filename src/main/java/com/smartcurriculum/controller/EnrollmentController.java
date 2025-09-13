package com.smartcurriculum.controller;

import com.smartcurriculum.entities.Enrollment;
import com.smartcurriculum.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    // ➡️ Create or update enrollment
    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        return ResponseEntity.ok(enrollmentService.saveEnrollment(enrollment));
    }

    // ➡️ Get enrollment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable String id) {
        Optional<Enrollment> enrollment = enrollmentService.getEnrollmentById(id);
        return enrollment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➡️ Get enrollment by section + student
    @GetMapping("/section/{sectionId}/student/{studentId}")
    public ResponseEntity<Enrollment> getEnrollmentBySectionAndStudent(
            @PathVariable String sectionId,
            @PathVariable String studentId) {
        Optional<Enrollment> enrollment = enrollmentService.getEnrollmentBySectionAndStudent(sectionId, studentId);
        return enrollment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➡️ Get enrollments by section
    @GetMapping("/section/{sectionId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsBySectionId(@PathVariable String sectionId) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentsBySectionId(sectionId));
    }

    // ➡️ Get enrollments by student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentsByStudentId(studentId));
    }

    // ➡️ Get all enrollments
    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    // ➡️ Delete enrollment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable String id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}
