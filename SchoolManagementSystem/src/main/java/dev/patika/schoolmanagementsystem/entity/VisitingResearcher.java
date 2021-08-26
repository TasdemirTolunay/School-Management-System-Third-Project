package dev.patika.schoolmanagementsystem.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VisitingResearcher extends Instructor {

    private double hourlySalary;

}
