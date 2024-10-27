package org.example.controllers;



import org.example.booksclient.contract.WorkDto;
import org.example.model.Work;

import org.example.mappers.WorkMapper;

import org.example.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/works")
public class WorkController {

    private final WorkService workService;
    private final WorkMapper workMapper;

    @Autowired
    public WorkController(WorkService workService, WorkMapper workMapper) {
        this.workService = workService;
        this.workMapper = workMapper;
    }

    @PostMapping("/create")
    public WorkDto createWork(@RequestBody WorkDto workDto) {
        Work work = workMapper.map(workDto);
        Work savedWork = workService.saveWork(work);
        return workMapper.toDto(savedWork);
    }

    @GetMapping("/getAll")
    public List<WorkDto> getAllWorks() {
        return workService.getAllWorks().stream()
                .map(workMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public WorkDto updateWork(@PathVariable Long id, @RequestBody WorkDto workDto) {
        Work existingWork = workService.getWorkById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Work not found"));
        Work updatedWork = workMapper.map(workDto);
        updatedWork.setId(existingWork.getId());
        workService.saveWork(updatedWork);
        return workMapper.toDto(updatedWork);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable Long id) {
        workService.deleteWork(id);
        return ResponseEntity.ok().build();
    }
}
