package org.example.controllers;

import org.example.booksclient.contract.SubjectDto;
import org.example.mappers.SubjectMapper;
import org.example.model.Subject;

import org.example.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    @Autowired
    public SubjectController(SubjectService subjectService, SubjectMapper subjectMapper) {
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
    }

    @PostMapping("/create")
    public SubjectDto createSubject(@RequestBody SubjectDto subjectDto) {
        Subject subject = subjectMapper.map(subjectDto);
        Subject savedSubject = subjectService.saveSubject(subject);
        return subjectMapper.toDto(savedSubject);
    }

    @GetMapping("/getAll")
    public List<SubjectDto> getAllSubjects() {
        return subjectService.getAllSubjects().stream()
                .map(subjectMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public SubjectDto updateSubject(@PathVariable Long id, @RequestBody SubjectDto subjectDto) {
        Subject existingSubject = subjectService.getSubjectById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found"));
        Subject updatedSubject = subjectMapper.map(subjectDto);
        updatedSubject.setId(existingSubject.getId());
        subjectService.saveSubject(updatedSubject);
        return subjectMapper.toDto(updatedSubject);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.ok().build();
    }
}
