package org.example.mappers;

import org.example.booksclient.contract.SubjectDto;
import org.example.booksclient.contract.WorkDto;
import org.example.model.Subject;
import org.example.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class SubjectMapper implements IMap<SubjectDto, Subject> {
    private final WorkMapper workMapper;
    @Autowired
    public SubjectMapper(WorkMapper workMapper) {
        this.workMapper = workMapper;
    }

    @Override
    public Subject map(SubjectDto subjectDto) {
        return map(subjectDto,new Subject());
    }

    @Override
    public Subject map(SubjectDto subjectDto, Subject subject) {
        if (subject == null) {
            subject = new Subject();
        }
        subject.setKey(subjectDto.getKey());
        subject.setName(subjectDto.getName());
        subject.setWorkCount(subjectDto.getWorkCount());

        if (subjectDto.getWorks() != null) {
            List<Work> works = subjectDto.getWorks().stream()
                    .map(workDto -> workMapper.map(workDto, new Work()))
                    .collect(Collectors.toList());
            subject.setWorks(works);
        }

        return subject;
    }
    public SubjectDto toDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setKey(subject.getKey());
        subjectDto.setName(subject.getName());
        subjectDto.setWorkCount(subject.getWorkCount());

        if (subject.getWorks() != null) {
            List<WorkDto> workDtos = subject.getWorks().stream()
                    .map(workMapper::toDto) // Załóżmy, że istnieje odpowiednia metoda toDto w klasie WorkMapper
                    .collect(Collectors.toList());
            subjectDto.setWorks(workDtos);
        }

        return subjectDto;
    }
}
