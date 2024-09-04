package org.example.springboot.services.minitest;

import org.example.springboot.model.minitest.Tour;
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

    public Page<Tour> tour2Page(Pageable pageable) {
        return minitest2Repository.findAll(pageable);
    }

    public Page<Tour> searchTour(String query, Pageable pageable) {
        return minitest2Repository.findByCodeContainingIgnoreCase(query, pageable);
    }

    public List<Tour> listTour() {
        return minitest2Repository.findAll();
    }
    public Tour findById(int id) {
        return minitest2Repository.findById(id).orElse(null);
    }

    public void saveTour(Tour tour2) {
        minitest2Repository.save(tour2);
    }

    public void updateTour(Tour tour2) {
        minitest2Repository.save(tour2);
    }

    public Tour getTourById(int id) {
        return minitest2Repository.findById(id).orElse(null);
    }

    public void deleteTour(int id) {
        minitest2Repository.deleteById(id);
    }
}