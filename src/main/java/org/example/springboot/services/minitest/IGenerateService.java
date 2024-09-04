package org.example.springboot.services.minitest;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void remove(int id);
}