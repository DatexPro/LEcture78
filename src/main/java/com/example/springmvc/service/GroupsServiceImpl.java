package com.example.springmvc.service;

import com.example.springmvc.Dao.GroupsDao;
import com.example.springmvc.model.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
public class GroupsServiceImpl implements GroupsService {
    @Autowired
    private GroupsDao studentGroupsDao;

    @Override
    public void create(StudentGroup group) {
        studentGroupsDao.save(group);
    }

    @Override
    public List<StudentGroup> readAll() {
        List<StudentGroup> allGroup = new ArrayList<>();
        Iterator<StudentGroup> studentGroupIterator = studentGroupsDao.findAll().iterator();
        while (studentGroupIterator.hasNext()){
            allGroup.add(studentGroupIterator.next());
        }
        return allGroup;
    }

    @Override
    public StudentGroup read(Long id) {
        Optional<StudentGroup> studentGroup = studentGroupsDao.findById(id);
        StudentGroup group = null;
        if (studentGroup.isPresent()){
            group = studentGroup.get();
        }
        return group;
    }

    @Override
    public boolean update(StudentGroup group, Long id) {
        if (studentGroupsDao.existsById(id)){
            group.setId(id);
            studentGroupsDao.save(group);
            return true;
        }
        return false;
    }


    @Override
    public boolean delete(long id) {
        if (studentGroupsDao.existsById(id)) {
            studentGroupsDao.deleteById(id);
            return true;
        }
        return false;
    }
}
