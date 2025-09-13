package com.smartcurriculum.services;

import com.smartcurriculum.entities.Section;

import java.util.List;
import java.util.Optional;

public interface SectionService {
    Section saveSection(Section section);
    Optional<Section> getSectionById(String id);
    List<Section> getSectionsByCourseId(String courseId);
    List<Section> getSectionsByTeacherId(String teacherId);
    List<Section> getSectionsByTerm(String term);
    List<Section> getAllSections();
    void deleteSection(String id);
}
