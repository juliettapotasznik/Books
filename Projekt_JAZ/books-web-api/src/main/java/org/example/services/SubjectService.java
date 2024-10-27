package org.example.services;

import org.example.model.Subject;

import org.example.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public Subject updateSubject(Long id, Subject subject) {
        return subjectRepository.findById(id)
                .map(existingSubject -> {
                    existingSubject.setName(subject.getName());
                    existingSubject.setWorkCount(subject.getWorkCount());
                    existingSubject.setWorks(subject.getWorks());
                    return subjectRepository.save(existingSubject);
                })
                .orElseThrow(() -> new RuntimeException("Subject not found with id " + id));
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
