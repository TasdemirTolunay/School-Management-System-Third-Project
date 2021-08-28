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

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String country;
    private String city;
    private String plateCode;

    public Address(String country, String city, String plateCode) {
        this.country = country;
        this.city = city;
        this.plateCode = plateCode;
    }

    @ApiModelProperty(hidden = true)
    @OneToMany(mappedBy = "address")
    private List<Student> studentList = new ArrayList<>();

    @ApiModelProperty(hidden = true)
    @OneToMany(mappedBy = "address")
    private List<Instructor> instructorList = new ArrayList<>();
}
