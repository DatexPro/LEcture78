package com.example.springmvc.Dao;

import com.example.springmvc.model.StudentGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;
import java.util.List;

public interface GroupsDao extends CrudRepository<StudentGroup, Long> {
}