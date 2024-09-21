package org.example.springboot.services.minitest;

import org.example.springboot.model.minitest.Student;
import org.example.springboot.repository.mititest.MinitestTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinitestService {
    @Autowired
    private MinitestTourRepository minitest2Repository;

    public Page<Student> tourPage(Pageable pageable) {
        return minitest2Repository.findAll(pageable);
    }

    public Page<Student> searchTour(String query, Pageable pageable) {
        return minitest2Repository.findByNameContainingIgnoreCase(query, pageable);
    }

    public List<Student> listTour() {
        return minitest2Repository.findAll();
    }
    public Student findById(int id) {
        return minitest2Repository.findById(id).orElse(null);
    }

    public void saveTour(Student student2) {
        minitest2Repository.save(student2);
    }

    public void updateTour(Student student2) {
        minitest2Repository.save(student2);
    }

    public Student getTourById(int id) {
        return minitest2Repository.findById(id).orElse(null);
    }

    public void deleteTour(int id) {
        minitest2Repository.deleteById(id);
    }
}