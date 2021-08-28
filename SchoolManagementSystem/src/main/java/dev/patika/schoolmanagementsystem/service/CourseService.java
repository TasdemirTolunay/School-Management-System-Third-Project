package dev.patika.schoolmanagementsystem.service;

import dev.patika.schoolmanagementsystem.entity.Course;
import dev.patika.schoolmanagementsystem.entity.Instructor;
import dev.patika.schoolmanagementsystem.entity.Student;
import dev.patika.schoolmanagementsystem.repository.CourseRepository;
import dev.patika.schoolmanagementsystem.repository.InstructorRepository;
import dev.patika.schoolmanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//This class contains methods of transaction on the address.
@Service
@RequiredArgsConstructor
public class CourseService implements ServiceRepository<Course> {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;

    @Override
    public List<Course> findAll() {

        List<Course> courses = new ArrayList<>();
        Iterable<Course> courseIterable = courseRepository.findAll();
        courseIterable.iterator().forEachRemaining(courses :: add);
        return courses;

    }

    @Override
    public Course findById(int id) {

        return courseRepository.findById(id).get();

    }

    @Override
    @Transactional
    public Course save(Course course) {

        return courseRepository.save(course);

    }

    @Override
    @Transactional
    public Course update(Course course, int id) {

        Course findCourse = findById(id);
        findCourse.setCourseName(course.getCourseName());
        findCourse.setCourseCode(course.getCourseCode());
        findCourse.setCourseCreditScore(course.getCourseCreditScore());
        return courseRepository.save(findCourse);

    }

    @Override
    @Transactional
    public String deleteById(int id) {

        courseRepository.deleteById(id);
        return "Course id = " + id + " Deleted....";

    }

    @Override
    @Transactional
    public String deleteObject(Course course) {

        courseRepository.delete(course);
        return "Course Deleted.....";

    }

    public List<Course> findCourseByName(String courseName){

        return courseRepository.findByCourseName(courseName);

    }

    public List<Course> findCourseByNameContaining(String courseName){

        return courseRepository.findByCourseNameContaining(courseName);

    }

    public String deleteCourseByName(String courseName){

        courseRepository.deleteByCourseName(courseName);
        return courseName + " Course Deleted....";

    }

    public List<Student> studentsOfCourse(int id){

        return findById(id).getStudents();

    }

    public Instructor instructorOfCourse(int id){

        return findById(id).getInstructor();

    }

    @Transactional
    public void setStudentOfCourse(int courseId, int studentId){

        Student findStudent = studentRepository.findById(studentId).get();
        Course findCourse = findById(courseId);
        findCourse.getStudents().add(findStudent);
        update(findCourse,courseId);

    }

    @Transactional
    public void setInstructorOfCourse(int courseId, int instructorId){

        Instructor findInstructor = instructorRepository.findById(instructorId).get();
        Course findCourse = findById(courseId);
        findCourse.setInstructor(findInstructor);
        update(findCourse, courseId);

    }

}
