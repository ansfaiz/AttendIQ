package com.smartcurriculum.services.impl;

import com.smartcurriculum.entities.Course;
import com.smartcurriculum.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements com.smartcurriculum.services.CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    @Override
    public Optional<Course> getCourseByCode(String code) {
        return courseRepository.findByCode(code);
    }

    @Override
    public List<Course> getCoursesByDepartment(String department) {
        return courseRepository.findByDepartment(department);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
