package dev.patika.schoolmanagementsystem.controller;

import dev.patika.schoolmanagementsystem.entity.Address;
import dev.patika.schoolmanagementsystem.entity.Instructor;
import dev.patika.schoolmanagementsystem.entity.Student;
import dev.patika.schoolmanagementsystem.service.AddressService;
import dev.patika.schoolmanagementsystem.service.InstructorService;
import dev.patika.schoolmanagementsystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    AddressService addressService;
    InstructorService instructorService;
    StudentService studentService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Address>> findAllAddress(){

        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findAddressById(@PathVariable int id){

        return new ResponseEntity<>(addressService.findById(id), HttpStatus.OK);

    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Address>> findAddressByCountry(@PathVariable String country){

        return new ResponseEntity<>(addressService.findAddressByCountry(country), HttpStatus.OK);

    }
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Address>> findAddressByCity(@PathVariable String city){

        return new ResponseEntity<>(addressService.findAddressByCity(city), HttpStatus.OK);

    }
    @GetMapping("/plateCode/{plateCode}")
    public ResponseEntity<List<Address>> findAddressByPlateCode(@PathVariable String plateCode){

        return new ResponseEntity<>(addressService.findAddressByPlateCode(plateCode), HttpStatus.OK);

    }

    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> addressStudents(@PathVariable int id){

        return new ResponseEntity<>(addressService.studentsOfAddress(id), HttpStatus.OK);

    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<List<Instructor>> addressInstructors(@PathVariable int id){

        return new ResponseEntity<>(addressService.instructorOfAddress(id), HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){

        return new ResponseEntity<>(addressService.save(address), HttpStatus.ACCEPTED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable int id){

        return new ResponseEntity<>(addressService.update(address, id), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable int id){

        return new ResponseEntity<>(addressService.deleteById(id), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddressByObject(@RequestBody Address address){

        return new ResponseEntity<>(addressService.deleteObject(address), HttpStatus.ACCEPTED);

    }

}
