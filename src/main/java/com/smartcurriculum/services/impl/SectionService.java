package com.smartcurriculum.services.impl;

import com.smartcurriculum.entities.Section;
import com.smartcurriculum.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SectionService implements com.smartcurriculum.services.SectionService {

    private final SectionRepository sectionRepository;

    @Override
    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Optional<Section> getSectionById(String id) {
        return sectionRepository.findById(id);
    }

    @Override
    public List<Section> getSectionsByCourseId(String courseId) {
        return sectionRepository.findByCourseId(courseId);
    }

    @Override
    public List<Section> getSectionsByTeacherId(String teacherId) {
        return sectionRepository.findByTeacherId(teacherId);
    }

    @Override
    public List<Section> getSectionsByTerm(String term) {
        return sectionRepository.findByTerm(term);
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public void deleteSection(String id) {
        sectionRepository.deleteById(id);
    }
}
