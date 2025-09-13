package com.smartcurriculum.services;


import com.smartcurriculum.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course saveCourse(Course course);
    Optional<Course> getCourseById(String id);
    Optional<Course> getCourseByCode(String code);
    List<Course> getCoursesByDepartment(String department);
    List<Course> getAllCourses();
    void deleteCourse(String id);
}
