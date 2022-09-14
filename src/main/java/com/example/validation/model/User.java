package com.example.validation.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user_tbl",uniqueConstraints = {@UniqueConstraint(columnNames = "email",name = "email_constraint")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer userId;
    private String name;
    private String address;
    //2@Column(unique = true)
    private String email;
    private String nationality;
}
