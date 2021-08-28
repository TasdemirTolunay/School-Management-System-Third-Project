package dev.patika.schoolmanagementsystem.repository;

import dev.patika.schoolmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    // Derived queries
    List<Student> findByStudentName(String name);
    List<Student> findByStudentNameContaining(String name);
    void deleteByStudentName(String name);

    // Custom query
    @Query("select s.studentGender , count(s.studentGender) from Student s group by s.studentGender")
    List<?> getGenderWithGrouping();

}
