package dev.patika.schoolmanagementsystem.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;
    private LocalDate studentBirthDate;
    @Enumerated(EnumType.STRING)
    private Gender studentGender;

    public Student(String studentName, LocalDate studentBirthDate, Gender studentGender) {
        this.studentName = studentName;
        this.studentBirthDate = studentBirthDate;
        this.studentGender = studentGender;
    }

    @ApiModelProperty(hidden = true)
    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    @ApiModelProperty(hidden = true)
    @ManyToOne
    private Address address;


}
