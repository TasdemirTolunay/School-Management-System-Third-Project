package dev.patika.schoolmanagementsystem.service;

import dev.patika.schoolmanagementsystem.entity.Address;
import dev.patika.schoolmanagementsystem.entity.Course;
import dev.patika.schoolmanagementsystem.entity.Student;
import dev.patika.schoolmanagementsystem.repository.AddressRepository;
import dev.patika.schoolmanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//This class contains methods of transaction on the address.
@Service
@RequiredArgsConstructor
public class StudentService implements ServiceRepository<Student> {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<Student> findAll() {

        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.iterator().forEachRemaining(studentList :: add);
        return studentList;

    }

    @Override
    public Student findById(int id) {

        return studentRepository.findById(id).get();

    }

    @Override
    @Transactional
    public Student save(Student student) {

        return studentRepository.save(student);

    }

    @Override
    @Transactional
    public Student update(Student student, int id) {

        Student findStudent = findById(id);
        findStudent.setStudentName(student.getStudentName());
        findStudent.setStudentGender(student.getStudentGender());
        findStudent.setStudentBirthDate(student.getStudentBirthDate());
        return studentRepository.save(findStudent);

    }

    @Override
    @Transactional
    public String  deleteById(int id) {

        studentRepository.deleteById(id);
        return "Student id = " + id + " Deleted.....";

    }

    @Override
    @Transactional
    public String  deleteObject(Student student) {

        studentRepository.delete(student);
        return "Student Deleted....";

    }

    public List<Student> findStudentByName(String studentName){

        return studentRepository.findByStudentName(studentName);

    }

    public List<Student> findStudentByNameContaining(String studentName){

        return studentRepository.findByStudentNameContaining(studentName);

    }

    public String deleteStudentByName(String studentName){

        studentRepository.deleteByStudentName(studentName);
        return studentName + " Student Deleted....";

    }

    public List<?> genderGroups(){

        return studentRepository.getGenderWithGrouping();

    }

    public List<Course> findCourseOfStudent(int id){

        return findById(id).getCourses();

    }

    public Address findAddressOfStudent(int id){

        return findById(id).getAddress();

    }

    @Transactional
    public void setAddressOfStudent(int studentId, int addressId){

        Address findAddress = addressRepository.findById(addressId).get();
        Student findStudent = findById(studentId);
        findStudent.setAddress(findAddress);
        update(findStudent, studentId);

    }

}
