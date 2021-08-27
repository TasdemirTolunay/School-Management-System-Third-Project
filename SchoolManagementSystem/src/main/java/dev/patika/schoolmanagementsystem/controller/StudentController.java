package dev.patika.schoolmanagementsystem.controller;

import dev.patika.schoolmanagementsystem.entity.Address;
import dev.patika.schoolmanagementsystem.entity.Course;
import dev.patika.schoolmanagementsystem.entity.Student;
import dev.patika.schoolmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> findAllStudent(){

        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id){

        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);

    }

    @GetMapping("/{studentName}")
    public ResponseEntity<List<Student>> findStudentByName(@PathVariable String studentName){

        return new ResponseEntity<>(studentService.findStudentByName(studentName), HttpStatus.OK);

    }

    @GetMapping("/name")
    public ResponseEntity<List<Student>> findStudentByRequestName(@RequestParam String studentName){

        return new ResponseEntity<>(studentService.findStudentByName(studentName), HttpStatus.OK);

    }

    @GetMapping("/containing/{studentName}")
    public ResponseEntity<List<Student>> findStudentByNameContaining(@PathVariable String studentName){

        return new ResponseEntity<>(studentService.findStudentByNameContaining(studentName), HttpStatus.OK);

    }

    @GetMapping("/containing")
    public ResponseEntity<List<Student>> findStudentByRequestNameContaining(@RequestParam String studentName){

        return new ResponseEntity<>(studentService.findStudentByNameContaining(studentName), HttpStatus.OK);

    }

    @GetMapping("/genderGroups")
    public ResponseEntity<List<?>> getGenderGroups(){

        return new ResponseEntity<>(studentService.genderGroups(), HttpStatus.OK);

    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<Course>> findStudentCourses(@PathVariable int id){

        return new ResponseEntity<>(studentService.findCourseOfStudent(id), HttpStatus.OK);

    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findStudentAddress(@PathVariable int id){

        return new ResponseEntity<>(studentService.findAddressOfStudent(id), HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){

        return new ResponseEntity<>(studentService.save(student), HttpStatus.ACCEPTED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){

        return new ResponseEntity<>(studentService.update(student, id), HttpStatus.ACCEPTED);

    }

    @PutMapping("/set/{studentId}/{addressId}")
    public ResponseEntity<String> setAddressOfStudent(@PathVariable int addressId, @PathVariable int studentId){

        studentService.setAddressOfStudent(addressId,studentId);
        return new ResponseEntity<>("Set Updated...", HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id){

        return new ResponseEntity<>(studentService.deleteById(id), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudentByObject(@RequestBody Student student){

        return new ResponseEntity<>(studentService.deleteObject(student), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deleteName/{studentName}")
    public ResponseEntity<String> deleteStudentByName(@PathVariable String studentName){

        return new ResponseEntity<>(studentService.deleteStudentByName(studentName), HttpStatus.ACCEPTED);

    }

}
