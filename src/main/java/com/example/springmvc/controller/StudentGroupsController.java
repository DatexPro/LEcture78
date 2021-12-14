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
import java.util.Map;

@RestController
public class StudentGroupsController {
    @Autowired
    private GroupsServiceImpl studentsGroupService;
    private StudentServiceI studentService;

    @GetMapping(value = "/studentGroups")
    public ResponseEntity<List<StudentGroup>> read() {
        final List<StudentGroup> studentGroups = studentsGroupService.readAll();
        return new ResponseEntity<>(studentGroups, HttpStatus.OK);
    }

    @GetMapping(value = "/studentGroups/{id}/students")
    public ResponseEntity<List<Student>> readStudent(@PathVariable(name = "id") Long groupID) {
        if (studentsGroupService.read(groupID) != null) {
            List<Student> students = studentService.readAllStudentsByGroup(groupID);
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/studentGroups/{id}")
    public ResponseEntity<StudentGroup> read(@PathVariable(name = "id") Long id) {
        final StudentGroup studentGroup = studentsGroupService.read(id);

        return studentGroup != null
                ? new ResponseEntity<>(studentGroup, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/studentGroups")
    public ResponseEntity<?> create(@Valid @RequestBody StudentGroup studentGroup) {
        studentsGroupService.create(studentGroup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/studentGroups/{id}")
    public ResponseEntity<?> update(@RequestBody StudentGroup studentGroup, Long id) {
        final boolean updated = studentsGroupService.update(studentGroup, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/studentGroups/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        studentsGroupService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}