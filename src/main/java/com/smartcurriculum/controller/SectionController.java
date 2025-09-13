package com.smartcurriculum.controller;

import com.smartcurriculum.entities.Section;
import com.smartcurriculum.services.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sections")
@RequiredArgsConstructor
public class SectionController {

    private final SectionService sectionService;

    // ➡️ Create or update section
    @PostMapping
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        return ResponseEntity.ok(sectionService.saveSection(section));
    }

    // ➡️ Get section by ID
    @GetMapping("/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable String id) {
        Optional<Section> section = sectionService.getSectionById(id);
        return section.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➡️ Get sections by course
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Section>> getSectionsByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(sectionService.getSectionsByCourseId(courseId));
    }

    // ➡️ Get sections by teacher
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Section>> getSectionsByTeacherId(@PathVariable String teacherId) {
        return ResponseEntity.ok(sectionService.getSectionsByTeacherId(teacherId));
    }

    // ➡️ Get sections by term
    @GetMapping("/term/{term}")
    public ResponseEntity<List<Section>> getSectionsByTerm(@PathVariable String term) {
        return ResponseEntity.ok(sectionService.getSectionsByTerm(term));
    }

    // ➡️ Get all sections
    @GetMapping
    public ResponseEntity<List<Section>> getAllSections() {
        return ResponseEntity.ok(sectionService.getAllSections());
    }

    // ➡️ Delete section
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable String id) {
        sectionService.deleteSection(id);
        return ResponseEntity.noContent().build();
    }
}
