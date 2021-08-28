package dev.patika.schoolmanagementsystem.entity;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;
    private String courseCode;
    private double courseCreditScore;

    public Course(String courseName, String courseCode, double courseCreditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCreditScore = courseCreditScore;
    }

    @ApiModelProperty(hidden = true)
    @ManyToMany
    private List<Student> students = new ArrayList<>();

    @ApiModelProperty(hidden = true)
    @ManyToOne
    private Instructor instructor;
}
