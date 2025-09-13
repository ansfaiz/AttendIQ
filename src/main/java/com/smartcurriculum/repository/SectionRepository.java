package com.smartcurriculum.repository;

import com.smartcurriculum.entities.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// ===================== SECTION =====================
@Repository
public interface SectionRepository extends MongoRepository<Section, String> {
    List<Section> findByCourseId(String courseId);

    List<Section> findByTeacherId(String teacherId);

    List<Section> findByTerm(String term);
}
