package dev.patika.schoolmanagementsystem.controller;

import dev.patika.schoolmanagementsystem.entity.*;
import dev.patika.schoolmanagementsystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller class
@RestController
@RequestMapping("/instructor")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    //Shows the instructor list
    @GetMapping("/list")
    public ResponseEntity<List<Instructor>> findAllInstructor(){

        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);

    }

    //Shows the instructor of the entered ID
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){

        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);

    }

    //Shows the instructor of the entered name.
    @GetMapping("/instructorName/{instructorName}")
    public ResponseEntity<List<Instructor>> findInstructorByName(@PathVariable String instructorName){

        return new ResponseEntity<>(instructorService.findInstructorByName(instructorName), HttpStatus.OK);

    }

    //Shows the instructor of the entered name.
    @GetMapping("/name")
    public ResponseEntity<List<Instructor>> findInstructorByRequestName(@RequestParam String instructorName){

        return new ResponseEntity<>(instructorService.findInstructorByName(instructorName), HttpStatus.OK);

    }

    // Shows the Instructor containing the entered name.
    @GetMapping("/containing/{instructorName}")
    public ResponseEntity<List<Instructor>> findInstructorByNameContaining(@PathVariable String instructorName){

        return new ResponseEntity<>(instructorService.findInstructorByNameContaining(instructorName), HttpStatus.OK);

    }

    // Shows the Instructor containing the entered name.
    @GetMapping("/containing")
    public ResponseEntity<List<Instructor>> findInstructorByRequestNameContaining(@RequestParam String instructorName){

        return new ResponseEntity<>(instructorService.findInstructorByNameContaining(instructorName), HttpStatus.OK);

    }

    //Shows courses registered to the instructor with the entered ID
    @GetMapping("/courses/{id}")
    public ResponseEntity<List<Course>> findInstructorCourses(@PathVariable int id){

        return new ResponseEntity<>(instructorService.coursesOfInstructor(id), HttpStatus.OK);

    }

    //Shows address registered to the instructor with the entered ID
    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findInstructorAddress(@PathVariable int id){

        return new ResponseEntity<>(instructorService.addressOfInstructor(id), HttpStatus.OK);

    }

    //Three PermanentInstructor with a minimum salary
    @GetMapping("/minfixedsalary")
    public ResponseEntity<List<Instructor>> first3MinFixedSalary(){

        return new ResponseEntity<>(instructorService.first3InstructorOfMinFixedSalary(), HttpStatus.OK);

    }

    //Three PermanentInstructor with a maximum salary
    @GetMapping("/maxfixedsalary")
    public ResponseEntity<List<Instructor>> first3MaxFixedSalary(){

        return new ResponseEntity<>(instructorService.first3InstructorOfMaxFixedSalary(), HttpStatus.OK);

    }

    //Three VisitingResearcher with a minimum salary
    @GetMapping("/minhourlysalary")
    public ResponseEntity<List<Instructor>> first3MinHourlySalary(){

        return new ResponseEntity<>(instructorService.first3InstructorOfMinHourlySalary(), HttpStatus.OK);

    }


    //Three VisitingResearcher with a maximum salary
    @GetMapping("/maxhourlysalary")
    public ResponseEntity<List<Instructor>> first3MaxHourlySalary(){

        return new ResponseEntity<>(instructorService.first3InstructorOfMaxHourlySalary(), HttpStatus.OK);

    }

    //New instructor information is created
    @PostMapping("/save")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor){

        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.ACCEPTED);

    }

    //New permanent instructor information is created
    @PostMapping("/save/permanent")
    public ResponseEntity<Instructor> permanentInstructorSave(@RequestBody PermanentInstructor instructor){

        return new ResponseEntity<>(instructorService.savePermanentInstructor(instructor),HttpStatus.ACCEPTED);

    }

    //New visiting instructor information is created
    @PostMapping("/save/visiting")
    public ResponseEntity<Instructor> visitingInstructorSave(@RequestBody VisitingResearcher instructor){

        return new ResponseEntity<>(instructorService.saveVisitingInstructor(instructor),HttpStatus.ACCEPTED);

    }

    //Instructor information update of the entered ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor, @PathVariable int id){

        return new ResponseEntity<>(instructorService.update(instructor, id), HttpStatus.ACCEPTED);

    }

    //Assigns the address to a instructor
    @PutMapping("/set/address/{instructorId}/{addressId}")
    public ResponseEntity<String> setAddressOfInstructor(@PathVariable int instructorId, @PathVariable int addressId){

        instructorService.setAddressOfInstructor(instructorId,addressId);
        return new ResponseEntity<>("Set Updated...", HttpStatus.ACCEPTED);

    }

    //Delete instructor information with id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInstructorById(@PathVariable int id){

        return new ResponseEntity<>(instructorService.deleteById(id), HttpStatus.ACCEPTED);

    }

    //Delete instructor information
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteInstructorByObject(@RequestBody Instructor instructor){

        return new ResponseEntity<>(instructorService.deleteObject(instructor), HttpStatus.ACCEPTED);

    }

    //Delete instructor information with name
    @DeleteMapping("/deleteName/{instructorName}")
    public ResponseEntity<String> deleteInstructorByName(@PathVariable String instructorName){

        return new ResponseEntity<>(instructorService.deleteInstructorByName(instructorName), HttpStatus.ACCEPTED);

    }

}
