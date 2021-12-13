package com.example.springmvc.controller;

import com.example.springmvc.model.Student;
import com.example.springmvc.model.StudentGroup;
import com.example.springmvc.service.GroupsServiceImpl;
import com.example.springmvc.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentGroupsController {

    private final GroupsServiceImpl studentsGroupService;
    private final StudentServiceI studentService;

    @Autowired
    public StudentGroupsController(GroupsServiceImpl studentsGroupService, StudentServiceI studentService) {
        this.studentsGroupService = studentsGroupService;
        this.studentService = studentService;
    }

    @GetMapping(value = "/studentGroups")
    public ResponseEntity<List<StudentGroup>> read() {
        final List<StudentGroup> studentGroups = studentsGroupService.getAllStudentGroups();
        return new ResponseEntity<>(studentGroups, HttpStatus.OK);
    }

    @GetMapping(value = "/studentGroups/{id}/students")
    public ResponseEntity<List<Student>> readStudent(@PathVariable(name = "id") Long groupID) {
        if (studentsGroupService.getStudentGroup(groupID) != null) {
            List<Student> students = studentService.getAllStudentsByGroup(groupID);
            return new ResponseEntity<>(students, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/studentGroups/{id}")
    public ResponseEntity<StudentGroup> read(@PathVariable(name = "id") int id) {
        final StudentGroup studentGroup = studentsGroupService.getStudentGroup(id);

        return studentGroup != null
                ? new ResponseEntity<>(studentGroup, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/studentGroups")
    public ResponseEntity<?> create(@Valid @RequestBody StudentGroup studentGroup) {
        studentsGroupService.saveStudentGroup(studentGroup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/studentGroups/{id}")
    public ResponseEntity<?> update(@RequestBody StudentGroup studentGroup) {
        final StudentGroup updated = studentsGroupService.updateStudentGroup(studentGroup);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/studentGroups/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        studentsGroupService.deleteStudentGroup(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}