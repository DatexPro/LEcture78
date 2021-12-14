package com.example.springmvc.service;

import com.example.springmvc.model.Student;

import java.util.List;

public interface StudentService {

    void create(Student student);

    List<Student> readAll();

    List<Student> readAllStudentsByGroup(Long groupId);

    Student read(long id);

    boolean update(Student student, Long id);

    boolean delete(long id);
}