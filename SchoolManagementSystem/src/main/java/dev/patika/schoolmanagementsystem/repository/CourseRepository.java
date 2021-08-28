package dev.patika.schoolmanagementsystem.repository;

import dev.patika.schoolmanagementsystem.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    // Derived queries
    List<Course> findByCourseName(String name);
    List<Course> findByCourseNameContaining(String name);

    void deleteByCourseName(String name);


}
