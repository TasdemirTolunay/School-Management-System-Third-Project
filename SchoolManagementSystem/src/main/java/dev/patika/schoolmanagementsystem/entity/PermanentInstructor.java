package dev.patika.schoolmanagementsystem.entity;

import lombok.*;

import javax.persistence.Entity;

//This class is a subclass of the instructor class
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PermanentInstructor extends Instructor{

    //Variables
    private double fixedSalary;

}
