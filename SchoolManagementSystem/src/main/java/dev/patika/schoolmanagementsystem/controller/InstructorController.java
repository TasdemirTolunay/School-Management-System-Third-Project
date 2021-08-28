package dev.patika.schoolmanagementsystem.controller;

import dev.patika.schoolmanagementsystem.entity.*;
import dev.patika.schoolmanagementsystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Instructor>> findAllInstructor(){

        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){

        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);

    }

    @GetMapping("/instructorName/{instructorName}")
    public ResponseEntity<List<Instructor>> findInstructorByName(@PathVariable String instructorName){

        return new ResponseEntity<>(instructorService.findInstructorByName(instructorName), HttpStatus.OK);

    }

    @GetMapping("/name")
    public ResponseEntity<List<Instructor>> findInstructorByRequestName(@RequestParam String instructorName){

        return new ResponseEntity<>(instructorService.findInstructorByName(instructorName), HttpStatus.OK);

    }

    @GetMapping("/containing/{instructorName}")
    public ResponseEntity<List<Instructor>> findInstructorByNameContaining(@PathVariable String instructorName){

        return new ResponseEntity<>(instructorService.findInstructorByNameContaining(instructorName), HttpStatus.OK);

    }

    @GetMapping("/containing")
    public ResponseEntity<List<Instructor>> findInstructorByRequestNameContaining(@RequestParam String instructorName){

        return new ResponseEntity<>(instructorService.findInstructorByNameContaining(instructorName), HttpStatus.OK);

    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<Course>> findInstructorCourses(@PathVariable int id){

        return new ResponseEntity<>(instructorService.coursesOfInstructor(id), HttpStatus.OK);

    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findInstructorAddress(@PathVariable int id){

        return new ResponseEntity<>(instructorService.addressOfInstructor(id), HttpStatus.OK);

    }

    @GetMapping("/minfixedsalary")
    public ResponseEntity<List<Instructor>> first3MinFixedSalary(){

        return new ResponseEntity<>(instructorService.first3InstructorOfMinFixedSalary(), HttpStatus.OK);

    }

    @GetMapping("/maxfixedsalary")
    public ResponseEntity<List<Instructor>> first3MaxFixedSalary(){

        return new ResponseEntity<>(instructorService.first3InstructorOfMaxFixedSalary(), HttpStatus.OK);

    }

    @GetMapping("/minhourlysalary")
    public ResponseEntity<List<Instructor>> first3MinHourlySalary(){

        return new ResponseEntity<>(instructorService.first3InstructorOfMinHourlySalary(), HttpStatus.OK);

    }

    @GetMapping("/maxhourlysalary")
    public ResponseEntity<List<Instructor>> first3MaxHourlySalary(){

        return new ResponseEntity<>(instructorService.first3InstructorOfMaxHourlySalary(), HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor){

        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.ACCEPTED);

    }

    @PostMapping("/save/permanent")
    public ResponseEntity<Instructor> permanentInstructorSave(@RequestBody PermanentInstructor instructor){

        return new ResponseEntity<>(instructorService.savePermanentInstructor(instructor),HttpStatus.ACCEPTED);

    }

    @PostMapping("/save/visiting")
    public ResponseEntity<Instructor> visitingInstructorSave(@RequestBody VisitingResearcher instructor){

        return new ResponseEntity<>(instructorService.saveVisitingInstructor(instructor),HttpStatus.ACCEPTED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor, @PathVariable int id){

        return new ResponseEntity<>(instructorService.update(instructor, id), HttpStatus.ACCEPTED);

    }

    @PutMapping("/set/address/{instructorId}/{addressId}")
    public ResponseEntity<String> setAddressOfInstructor(@PathVariable int instructorId, @PathVariable int addressId){

        instructorService.setAddressOfInstructor(instructorId,addressId);
        return new ResponseEntity<>("Set Updated...", HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInstructorById(@PathVariable int id){

        return new ResponseEntity<>(instructorService.deleteById(id), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteInstructorByObject(@RequestBody Instructor instructor){

        return new ResponseEntity<>(instructorService.deleteObject(instructor), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deleteName/{instructorName}")
    public ResponseEntity<String> deleteInstructorByName(@PathVariable String instructorName){

        return new ResponseEntity<>(instructorService.deleteInstructorByName(instructorName), HttpStatus.ACCEPTED);

    }

}
