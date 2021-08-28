package dev.patika.schoolmanagementsystem.service;

import dev.patika.schoolmanagementsystem.entity.*;
import dev.patika.schoolmanagementsystem.repository.AddressRepository;
import dev.patika.schoolmanagementsystem.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//This class contains methods of transaction on the address.
@Service
@RequiredArgsConstructor
public class InstructorService implements ServiceRepository<Instructor> {

    private final InstructorRepository instructorRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<Instructor> findAll() {

        List<Instructor> instructors = new ArrayList<>();
        Iterable<Instructor> instructorIterable = instructorRepository.findAll();
        instructorIterable.iterator().forEachRemaining(instructors :: add);
        return instructors;

    }

    @Override
    public Instructor findById(int id) {

        return instructorRepository.findById(id).get();

    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {

        return instructorRepository.save(instructor);

    }

    @Transactional
    public Instructor savePermanentInstructor(PermanentInstructor instructor){

        return instructorRepository.save(instructor);

    }

    @Transactional
    public Instructor saveVisitingInstructor(VisitingResearcher instructor){

        return instructorRepository.save(instructor);

    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor, int id) {

        Instructor findInstructor = findById(id);
        findInstructor.setInstructorName(instructor.getInstructorName());
        findInstructor.setInstructorPhoneNumber(instructor.getInstructorPhoneNumber());
        return instructorRepository.save(findInstructor);

    }

    @Override
    @Transactional
    public String deleteById(int id) {

        instructorRepository.deleteById(id);
        return "Instructor id = " + id + " Deleted....";

    }

    @Override
    @Transactional
    public String deleteObject(Instructor instructor) {

        instructorRepository.delete(instructor);
        return "Instructor Deleted....";

    }

    public List<Instructor> findInstructorByName(String instructorName){

        return instructorRepository.findByInstructorName(instructorName);

    }

    public List<Instructor> findInstructorByNameContaining(String instructorName){

        return instructorRepository.findByInstructorNameContaining(instructorName);

    }

    public String deleteInstructorByName(String name){

        instructorRepository.deleteByInstructorName(name);
        return name + " Instructor Deleted.....";

    }

    public List<Instructor> first3InstructorOfMinFixedSalary(){

        return instructorRepository.findFirst3MinFixedSalary();

    }

    public List<Instructor> first3InstructorOfMaxFixedSalary(){

        return instructorRepository.findFirst3MaxFixedSalary();

    }

    public List<Instructor> first3InstructorOfMinHourlySalary(){

        return instructorRepository.findFirst3MinHourlySalary();

    }

    public List<Instructor> first3InstructorOfMaxHourlySalary(){

        return instructorRepository.findFirst3MaxHourlySalary();

    }

    public List<Course> coursesOfInstructor(int id){

        return findById(id).getCourseList();

    }

    public Address addressOfInstructor(int id){

        return findById(id).getAddress();

    }

    @Transactional
    public void setAddressOfInstructor(int instructorId, int addressId){

        Address findAddress = addressRepository.findById(addressId).get();
        Instructor findInstructor = findById(instructorId);
        findInstructor.setAddress(findAddress);
        update(findInstructor, instructorId);

    }


}
