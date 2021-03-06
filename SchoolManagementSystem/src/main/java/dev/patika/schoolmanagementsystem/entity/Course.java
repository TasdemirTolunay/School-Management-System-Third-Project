package dev.patika.schoolmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Course {

    //This class have Primary key
    @ApiModelProperty(hidden = true) // Swagger Configration
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Variables
    private String courseName;
    private String courseCode;
    private double courseCreditScore;

    public Course(String courseName, String courseCode, double courseCreditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCreditScore = courseCreditScore;
    }

    //Relations with other classes
    @JsonBackReference
    @ApiModelProperty(hidden = true)
    @ManyToMany
    private List<Student> students = new ArrayList<>();

    @JsonBackReference
    @ApiModelProperty(hidden = true)
    @ManyToOne
    private Instructor instructor;
}
