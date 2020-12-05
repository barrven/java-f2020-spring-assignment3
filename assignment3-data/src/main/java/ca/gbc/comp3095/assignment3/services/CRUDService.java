package ca.gbc.comp3095.assignment3.services;

import java.util.Set;

public interface CRUDService<T, Id> {
    Set<T> findAll();
    T findById(Id id);
    T save(T object);
    void delete(T object);
    void deleteById(Id id);
}
