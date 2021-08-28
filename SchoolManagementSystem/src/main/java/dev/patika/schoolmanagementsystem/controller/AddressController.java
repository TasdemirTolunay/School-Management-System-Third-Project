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

//Controller class
@RestController
@RequestMapping("/address")
public class AddressController {

    AddressService addressService;
    InstructorService instructorService;
    StudentService studentService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    //Shows the address list
    @GetMapping("/list")
    public ResponseEntity<List<Address>> findAllAddress(){

        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);

    }

    //Shows the address of the entered ID.
    @GetMapping("/{id}")
    public ResponseEntity<Address> findAddressById(@PathVariable int id){

        return new ResponseEntity<>(addressService.findById(id), HttpStatus.OK);

    }

    //Shows the address of the entered country.
    @GetMapping("/country/{country}")
    public ResponseEntity<List<Address>> findAddressByCountry(@PathVariable String country){

        return new ResponseEntity<>(addressService.findAddressByCountry(country), HttpStatus.OK);

    }

    //Shows the address of the entered city.
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Address>> findAddressByCity(@PathVariable String city){

        return new ResponseEntity<>(addressService.findAddressByCity(city), HttpStatus.OK);

    }

    //Shows the address of the entered plateCode.
    @GetMapping("/plateCode/{plateCode}")
    public ResponseEntity<List<Address>> findAddressByPlateCode(@PathVariable String plateCode){

        return new ResponseEntity<>(addressService.findAddressByPlateCode(plateCode), HttpStatus.OK);

    }

    //Shows students registered to the address with the entered ID
    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> addressStudents(@PathVariable int id){

        return new ResponseEntity<>(addressService.studentsOfAddress(id), HttpStatus.OK);

    }

    //Shows instructors registered to the address with the entered ID
    @GetMapping("/instructors/{id}")
    public ResponseEntity<List<Instructor>> addressInstructors(@PathVariable int id){

        return new ResponseEntity<>(addressService.instructorOfAddress(id), HttpStatus.OK);

    }

    //New address information is created
    @PostMapping("/save")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){

        return new ResponseEntity<>(addressService.save(address), HttpStatus.ACCEPTED);

    }

    //Address information update of the entered ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable int id){

        return new ResponseEntity<>(addressService.update(address, id), HttpStatus.ACCEPTED);

    }

    //Delete address information with id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable int id){

        return new ResponseEntity<>(addressService.deleteById(id), HttpStatus.ACCEPTED);

    }

    //Delete address information
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddressByObject(@RequestBody Address address){

        return new ResponseEntity<>(addressService.deleteObject(address), HttpStatus.ACCEPTED);

    }

}
