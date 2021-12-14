package com.example.springmvc.Dao;

import com.example.springmvc.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsDao extends JpaRepository<StudentGroup, Long> {
}