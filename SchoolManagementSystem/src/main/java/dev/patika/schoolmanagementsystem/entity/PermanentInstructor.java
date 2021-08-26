package dev.patika.schoolmanagementsystem.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PermanentInstructor extends Instructor{

    private double fixedSalary;

}
