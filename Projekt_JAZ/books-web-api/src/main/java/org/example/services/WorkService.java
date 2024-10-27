package org.example.services;

import org.example.model.Work;

import org.example.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    private final WorkRepository workRepository;

    @Autowired
    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public Work saveWork(Work work) {
        return workRepository.save(work);
    }

    public Optional<Work> getWorkById(Long id) {
        return workRepository.findById(id);
    }

    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }

    public void deleteWork(Long id) {
        workRepository.deleteById(id);
    }

    public Work updateWork(Long id, Work work) {
        return workRepository.findById(id)
                .map(existingWork -> {
                    existingWork.setTitle(work.getTitle());
                    existingWork.setAuthors(work.getAuthors());
                    existingWork.setKey(work.getKey());
                    return workRepository.save(existingWork);
                })
                .orElseThrow(() -> new RuntimeException("Work not found"));
    }
}