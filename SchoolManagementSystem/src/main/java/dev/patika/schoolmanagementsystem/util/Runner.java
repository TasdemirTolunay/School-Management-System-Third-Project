package dev.patika.schoolmanagementsystem.util;

import dev.patika.schoolmanagementsystem.entity.*;
import dev.patika.schoolmanagementsystem.repository.AddressRepository;
import dev.patika.schoolmanagementsystem.repository.CourseRepository;
import dev.patika.schoolmanagementsystem.repository.InstructorRepository;
import dev.patika.schoolmanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


// Test data class
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {

        addressRepository.deleteAll();
        instructorRepository.deleteAll();
        courseRepository.deleteAll();
        studentRepository.deleteAll();

        Address address1 = Address.builder().country("Turkiye").city("Ankara").plateCode("06").build();
        Address address2 = Address.builder().country("Turkiye").city("Istanbul").plateCode("34").build();
        Address address3 = Address.builder().country("Turkiye").city("Eskisehir").plateCode("26").build();
        Address address4 = Address.builder().country("Turkiye").city("Adana").plateCode("01").build();
        Address address5 = Address.builder().country("Turkiye").city("Ankara").plateCode("06").build();

        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);
        addressRepository.save(address4);
        addressRepository.save(address5);

        Instructor instructor1 = PermanentInstructor.builder().instructorName("Koray Guney")
                .instructorPhoneNumber("+050050505").fixedSalary(5000.0).build();
        Instructor instructor2 = PermanentInstructor.builder().instructorName("Ahmet Ahmet")
                .instructorPhoneNumber("+955555555").fixedSalary(2500.0).build();
        Instructor instructor3 = PermanentInstructor.builder().instructorName("Ayse Ayse")
                .instructorPhoneNumber("+9566666666").fixedSalary(3000.0).build();
        Instructor instructor4 = VisitingResearcher.builder().instructorName("Ozge Ozge")
                .instructorPhoneNumber("+9577777777").hourlySalary(6500.0).build();
        Instructor instructor5 = VisitingResearcher.builder().instructorName("Vahid Vahid")
                .instructorPhoneNumber("+958888888").hourlySalary(4000.0).build();
        Instructor instructor6 = VisitingResearcher.builder().instructorName("aaaaa aaaaa")
                .instructorPhoneNumber("+955875544").hourlySalary(5000.0).build();

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);
        instructorRepository.save(instructor4);
        instructorRepository.save(instructor5);
        instructorRepository.save(instructor6);

        Student student1 = Student.builder().studentName("Tolunay").studentGender(Gender.Male)
                .studentBirthDate(LocalDate.of(1996,2,12)).build();
        Student student2 = Student.builder().studentName("Vahid").studentGender(Gender.Male)
                .studentBirthDate(LocalDate.of(1990,10,10)).build();
        Student student3 = Student.builder().studentName("Guven").studentGender(Gender.Male)
                .studentBirthDate(LocalDate.of(1995,8,8)).build();
        Student student4 = Student.builder().studentName("Oyku").studentGender(Gender.Female)
                .studentBirthDate(LocalDate.of(1998,3,9)).build();
        Student student5 = Student.builder().studentName("Natalie").studentGender(Gender.Female)
                .studentBirthDate(LocalDate.of(1985,4,5)).build();

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);

        courseRepository.save(Course.builder().courseName("Java spring boot camp")
                .courseCode("Js-0000113").courseCreditScore(25.0).build());
        courseRepository.save(Course.builder().courseName("Frontend boot camp")
                .courseCode("F-000010202").courseCreditScore(20.0).build());
        courseRepository.save(Course.builder().courseName("Mobil boot camp")
                .courseCode("M-0000252").courseCreditScore(28.0).build());
        courseRepository.save(Course.builder().courseName("React boot camp")
                .courseCode("R-0000166").courseCreditScore(21.0).build());
        courseRepository.save(Course.builder().courseName("Kotlin boot camp")
                .courseCode("Kt-000099").courseCreditScore(15.0).build());
        courseRepository.save(Course.builder().courseName("Java boot camp")
                .courseCode("J-000799").courseCreditScore(18.0).build());

    }

}
