package com.example.springmvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private String birthday;
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "id_group")
    private StudentGroup groupID;
}
