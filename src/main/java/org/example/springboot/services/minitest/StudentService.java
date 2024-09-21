package org.example.springboot.services.minitest;

import org.example.springboot.model.minitest.Student;
import org.example.springboot.repository.mititest.MinitestTourRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final MinitestTourRepository repository;

    public StudentService(MinitestTourRepository repository) {
        this.repository = repository;
    }

    public List<Student> findStudents(String name, String phone, String email) {
        Specification<Student> spec = Specification.where(StudentSpecifications.hasName(name))
                .and(StudentSpecifications.hasPhone(phone))
                .and(StudentSpecifications.hasGmail(email));

        return repository.findAll(spec);
    }
}
