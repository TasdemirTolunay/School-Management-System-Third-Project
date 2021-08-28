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

//Controller class
@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Shows the student list
    @GetMapping("/list")
    public ResponseEntity<List<Student>> findAllStudent(){

        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);

    }

    //Shows the student of the entered ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id){

        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);

    }

    //Shows the student of the entered name
    @GetMapping("/studentName/{studentName}")
    public ResponseEntity<List<Student>> findStudentByName(@PathVariable String studentName){

        return new ResponseEntity<>(studentService.findStudentByName(studentName), HttpStatus.OK);

    }

    //Shows the student of the entered name
    @GetMapping("/name")
    public ResponseEntity<List<Student>> findStudentByRequestName(@RequestParam String studentName){

        return new ResponseEntity<>(studentService.findStudentByName(studentName), HttpStatus.OK);

    }

    // Shows the Students containing the entered name.
    @GetMapping("/containing/{studentName}")
    public ResponseEntity<List<Student>> findStudentByNameContaining(@PathVariable String studentName){

        return new ResponseEntity<>(studentService.findStudentByNameContaining(studentName), HttpStatus.OK);

    }

    // Shows the Students containing the entered name.
    @GetMapping("/containing")
    public ResponseEntity<List<Student>> findStudentByRequestNameContaining(@RequestParam String studentName){

        return new ResponseEntity<>(studentService.findStudentByNameContaining(studentName), HttpStatus.OK);

    }

    // Shows a list grouped by gender
    @GetMapping("/genderGroups")
    public ResponseEntity<List<?>> getGenderGroups(){

        return new ResponseEntity<>(studentService.genderGroups(), HttpStatus.OK);

    }

    //Shows courses registered to the student with the entered ID
    @GetMapping("/courses/{id}")
    public ResponseEntity<List<Course>> findStudentCourses(@PathVariable int id){

        return new ResponseEntity<>(studentService.findCourseOfStudent(id), HttpStatus.OK);

    }

    //Shows address registered to the student with the entered ID
    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findStudentAddress(@PathVariable int id){

        return new ResponseEntity<>(studentService.findAddressOfStudent(id), HttpStatus.OK);

    }

    //New student information is created
    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){

        return new ResponseEntity<>(studentService.save(student), HttpStatus.ACCEPTED);

    }

    //Student information update of the entered ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){

        return new ResponseEntity<>(studentService.update(student, id), HttpStatus.ACCEPTED);

    }

    //Assigns the address to a student
    @PutMapping("/set/address/{studentId}/{addressId}}")
    public ResponseEntity<String> setAddressOfStudent(@PathVariable int studentId, @PathVariable int addressId){

        studentService.setAddressOfStudent(studentId,addressId);
        return new ResponseEntity<>("Set Updated...", HttpStatus.ACCEPTED);

    }

    //Delete student information with id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id){

        return new ResponseEntity<>(studentService.deleteById(id), HttpStatus.ACCEPTED);

    }

    //Delete student information
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudentByObject(@RequestBody Student student){

        return new ResponseEntity<>(studentService.deleteObject(student), HttpStatus.ACCEPTED);

    }

    //Delete student information with name
    @DeleteMapping("/deleteName/{studentName}")
    public ResponseEntity<String> deleteStudentByName(@PathVariable String studentName){

        return new ResponseEntity<>(studentService.deleteStudentByName(studentName), HttpStatus.ACCEPTED);

    }

}
