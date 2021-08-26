package dev.patika.schoolmanagementsystem.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;
    private LocalDate studentBirthDate;
    @Enumerated(EnumType.STRING)
    private Gender studentGender;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    @ManyToOne
    private Address address;


}
