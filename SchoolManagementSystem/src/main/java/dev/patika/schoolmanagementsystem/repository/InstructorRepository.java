package dev.patika.schoolmanagementsystem.repository;

import dev.patika.schoolmanagementsystem.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

    List<Instructor> findByInstructorName(String name);

    List<Instructor> findByInstructorNameContaining(String name);

    void deleteByInstructorName(String name);

    @Query(nativeQuery = true, value = "select TOP 3 from instructor order by fixed_salary")
    List<Instructor> findFirst3MinFixedSalary();

    @Query(nativeQuery = true, value = "select TOP 3 from instructor order by fixed_salary desc")
    List<Instructor> findFirst3MaxFixedSalary();

    @Query(nativeQuery = true, value = "select TOP 3 from instructor order by hourly_salary")
    List<Instructor> findFirst3MinHourlySalary();

    @Query(nativeQuery = true, value = "select TOP 3 from instructor order by hourly_salary desc")
    List<Instructor> findFirst3MaxHourlySalary();

}