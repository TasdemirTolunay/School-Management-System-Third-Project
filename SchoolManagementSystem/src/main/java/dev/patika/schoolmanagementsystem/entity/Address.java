package dev.patika.schoolmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Authorization;
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
public class Address {

    //This class have Primary key
    @ApiModelProperty(hidden = true) // Swagger Confıgration
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Variables
    private String country;
    private String city;
    private String plateCode;

    public Address(String country, String city, String plateCode) {
        this.country = country;
        this.city = city;
        this.plateCode = plateCode;
    }

    //Relations with other classes
    @ApiModelProperty(hidden = true)
    @OneToMany(mappedBy = "address")
    private List<Student> studentList = new ArrayList<>();

    @ApiModelProperty(hidden = true)
    @OneToMany(mappedBy = "address")
    private List<Instructor> instructorList = new ArrayList<>();
}
