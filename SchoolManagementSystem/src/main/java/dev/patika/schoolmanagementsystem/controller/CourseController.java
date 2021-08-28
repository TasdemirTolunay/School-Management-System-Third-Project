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

@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Course>> findAllCourse(){

        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){

        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);

    }

    @GetMapping("/courseName/{courseName}")
    public ResponseEntity<List<Course>> findCourseByName(@PathVariable String courseName){

        return new ResponseEntity<>(courseService.findCourseByName(courseName), HttpStatus.OK);

    }

    @GetMapping("/name")
    public ResponseEntity<List<Course>> findCourseByRequestName(@RequestParam String courseName){

        return new ResponseEntity<>(courseService.findCourseByName(courseName), HttpStatus.OK);

    }

    @GetMapping("/containing/{courseName}")
    public ResponseEntity<List<Course>> findCourseByNameContaining(@PathVariable String courseName){

        return new ResponseEntity<>(courseService.findCourseByNameContaining(courseName), HttpStatus.OK);

    }

    @GetMapping("/containing")
    public ResponseEntity<List<Course>> findCourseByRequestNameContaining(@RequestParam String courseName){

        return new ResponseEntity<>(courseService.findCourseByNameContaining(courseName), HttpStatus.OK);

    }

    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> findCourseStudents(@PathVariable int id){

        return new ResponseEntity<>(courseService.studentsOfCourse(id), HttpStatus.OK);

    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> findCourseInstructor(@PathVariable int id){

        return new ResponseEntity<>(courseService.instructorOfCourse(id), HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){

        return new ResponseEntity<>(courseService.save(course), HttpStatus.ACCEPTED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable int id){

        return new ResponseEntity<>(courseService.update(course, id), HttpStatus.ACCEPTED);

    }

    @PutMapping("/set/student{courseId}/{studentId}")
    public ResponseEntity<String> setStudentOfCourse(@PathVariable int courseId, @PathVariable int studentId){

        courseService.setStudentOfCourse(courseId,studentId);
        return new ResponseEntity<>("Set Updated...", HttpStatus.ACCEPTED);

    }
    @PutMapping("/set/instructor{courseId}/{instructorId}")
    public ResponseEntity<String> setInstructorOfCourse(@PathVariable int courseId, @PathVariable int instructorId){

        courseService.setInstructorOfCourse(courseId,instructorId);
        return new ResponseEntity<>("Set Updated...", HttpStatus.ACCEPTED);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable int id){

        return new ResponseEntity<>(courseService.deleteById(id), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCourseByObject(@RequestBody Course course){

        return new ResponseEntity<>(courseService.deleteObject(course), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deleteName/{courseName}")
    public ResponseEntity<String> deleteCourseByName(@PathVariable String courseName){

        return new ResponseEntity<>(courseService.deleteCourseByName(courseName), HttpStatus.ACCEPTED);

    }

}
