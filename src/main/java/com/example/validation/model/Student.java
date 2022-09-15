package com.example.validation.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name="fname_lname",    columnNames = {"first_name","last_name"})})
public class Student {
    @Id
    @SequenceGenerator(sequenceName = "student_seq_gen",name = "student_seq",allocationSize = 1)
    @GeneratedValue(generator = "student_seq_gen",strategy = GenerationType.SEQUENCE)

    private Integer student_id;
    private String first_name;
    private String last_name;
    private String address;
}
