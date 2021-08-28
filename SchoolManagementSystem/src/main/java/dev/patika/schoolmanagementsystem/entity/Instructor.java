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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Instructor {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String instructorName;
    private String instructorPhoneNumber;

    public Instructor(String instructorName, String instructorPhoneNumber) {
        this.instructorName = instructorName;
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    @ApiModelProperty(hidden = true)
    @ManyToOne
    private Address address;

    @ApiModelProperty(hidden = true)
    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();
}
