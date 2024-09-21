package org.example.springboot.model.minitest;

import java.util.List;

public class TourResponse {
    private List<Student> students;
    private int currentPage;
    private int totalPages;
    private int size;

    // Getters và Setters
    public List<Student> getTours() {
        return students;
    }

    public void setTours(List<Student> students) {
        this.students = students;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
