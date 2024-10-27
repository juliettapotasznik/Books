package org.example.repositories;

import org.example.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject getSubjectsByName(String name);
}
