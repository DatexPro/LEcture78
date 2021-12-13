package com.example.springmvc.service;

import com.example.springmvc.model.StudentGroup;

import java.util.List;
import java.util.Optional;

public interface GroupsService {


    void saveStudentGroup(StudentGroup group);

    List<StudentGroup> getAllStudentGroups();

    StudentGroup getStudentGroup(long id);

    StudentGroup updateStudentGroup(StudentGroup group);

    void deleteStudentGroup(long id);
}