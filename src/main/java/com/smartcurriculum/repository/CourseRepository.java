package com.smartcurriculum.repository;

import com.smartcurriculum.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// ===================== COURSE =====================
@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    Optional<Course> findByCode(String code);

    List<Course> findByDepartment(String department);
}
