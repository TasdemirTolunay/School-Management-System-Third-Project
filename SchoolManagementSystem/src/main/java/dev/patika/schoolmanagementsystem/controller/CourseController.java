package dev.patika.schoolmanagementsystem.controller;

import dev.patika.schoolmanagementsystem.entity.Course;
import dev.patika.schoolmanagementsystem.entity.Instructor;
import dev.patika.schoolmanagementsystem.entity.Student;
import dev.patika.schoolmanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Controller class
@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //Shows the course list
    @GetMapping("/list")
    public ResponseEntity<List<Course>> findAllCourse(){

        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);

    }

    //Shows the course of the entered ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){

        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);

    }

    //Shows the course of the entered courseName
    @GetMapping("/courseName/{courseName}")
    public ResponseEntity<List<Course>> findCourseByName(@PathVariable String courseName){

        return new ResponseEntity<>(courseService.findCourseByName(courseName), HttpStatus.OK);

    }

    //Shows the course of the entered courseName
    @GetMapping("/name")
    public ResponseEntity<List<Course>> findCourseByRequestName(@RequestParam String courseName){

        return new ResponseEntity<>(courseService.findCourseByName(courseName), HttpStatus.OK);

    }

    // Shows the courses containing the entered name.
    @GetMapping("/containing/{courseName}")
    public ResponseEntity<List<Course>> findCourseByNameContaining(@PathVariable String courseName){

        return new ResponseEntity<>(courseService.findCourseByNameContaining(courseName), HttpStatus.OK);

    }

    // Shows the courses containing the entered name.
    @GetMapping("/containing")
    public ResponseEntity<List<Course>> findCourseByRequestNameContaining(@RequestParam String courseName){

        return new ResponseEntity<>(courseService.findCourseByNameContaining(courseName), HttpStatus.OK);

    }

    //Shows students registered to the course with the entered ID
    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> findCourseStudents(@PathVariable int id){

        return new ResponseEntity<>(courseService.studentsOfCourse(id), HttpStatus.OK);

    }

    //Shows instructors registered to the course with the entered ID
    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> findCourseInstructor(@PathVariable int id){

        return new ResponseEntity<>(courseService.instructorOfCourse(id), HttpStatus.OK);

    }

    //New course information is created
    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){

        return new ResponseEntity<>(courseService.save(course), HttpStatus.ACCEPTED);

    }

    //Course information update of the entered ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable int id){

        return new ResponseEntity<>(courseService.update(course, id), HttpStatus.ACCEPTED);

    }

    //Assigns the student to a course
    @PutMapping("/set/student{courseId}/{studentId}")
    public ResponseEntity<String> setStudentOfCourse(@PathVariable int courseId, @PathVariable int studentId){

        courseService.setStudentOfCourse(courseId,studentId);
        return new ResponseEntity<>("Set Updated...", HttpStatus.ACCEPTED);

    }

    //Assigns the instructor to a course
    @PutMapping("/set/instructor{courseId}/{instructorId}")
    public ResponseEntity<String> setInstructorOfCourse(@PathVariable int courseId, @PathVariable int instructorId){

        courseService.setInstructorOfCourse(courseId,instructorId);
        return new ResponseEntity<>("Set Updated...", HttpStatus.ACCEPTED);

    }


    //Delete course information with id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable int id){

        return new ResponseEntity<>(courseService.deleteById(id), HttpStatus.ACCEPTED);

    }

    //Delete course information
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCourseByObject(@RequestBody Course course){

        return new ResponseEntity<>(courseService.deleteObject(course), HttpStatus.ACCEPTED);

    }

    //Delete course information with name
    @DeleteMapping("/deleteName/{courseName}")
    public ResponseEntity<String> deleteCourseByName(@PathVariable String courseName){

        return new ResponseEntity<>(courseService.deleteCourseByName(courseName), HttpStatus.ACCEPTED);

    }

}
