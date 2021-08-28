package dev.patika.schoolmanagementsystem.service;


import java.util.List;

// Interface for Service classes.
public interface ServiceRepository<T> {

    List<T> findAll();
    T findById(int id);
    T save(T object);
    T update(T object, int id);
    String  deleteById(int id);
    String  deleteObject(T object);

}
