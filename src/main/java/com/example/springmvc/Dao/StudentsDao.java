package com.example.springmvc.Dao;

import com.example.springmvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentsDao extends JpaRepository<Student, Long> {
    List<Student> getStudentByGroupID(Long id);
}