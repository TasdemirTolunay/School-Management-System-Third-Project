package dev.patika.schoolmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Instructor {

    //This class have Primary key
    @ApiModelProperty(hidden = true) // Swagger Configration
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Variables
    private String instructorName;
    private String instructorPhoneNumber;

    public Instructor(String instructorName, String instructorPhoneNumber) {
        this.instructorName = instructorName;
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    //Relations with other classes
    @JsonBackReference
    @ApiModelProperty(hidden = true)
    @ManyToOne
    private Address address;

    @JsonManagedReference
    @ApiModelProperty(hidden = true)
    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();
}
