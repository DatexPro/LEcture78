package com.example.springmvc.service;

import com.example.springmvc.model.StudentGroup;

import java.util.List;

public interface GroupsService {


    void create(StudentGroup group);

    List<StudentGroup> readAll();

    StudentGroup read(Long id);

    boolean update(StudentGroup group, Long id);

    boolean delete(long id);
}