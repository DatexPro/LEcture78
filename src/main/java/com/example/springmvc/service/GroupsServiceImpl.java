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

    private GroupsDao studentGroupsDao;

    @Autowired
    public GroupsServiceImpl(GroupsDao studentGroupsDao) {
        this.studentGroupsDao = studentGroupsDao;
    }

    @Override
    public void saveStudentGroup(StudentGroup group) {
        studentGroupsDao.save(group);
    }

    @Override
    public List<StudentGroup> getAllStudentGroups() {
        List<StudentGroup> allGroup = new ArrayList<>();
        Iterator<StudentGroup> studentGroupIterator = studentGroupsDao.findAll().iterator();
        while (studentGroupIterator.hasNext()){
            allGroup.add(studentGroupIterator.next());
        }
        return allGroup;
    }

    @Override
    public StudentGroup getStudentGroup(long id) {
        Optional<StudentGroup> studentGroup = studentGroupsDao.findById(id);
        StudentGroup group = null;
        if (studentGroup.isPresent()){
            group = studentGroup.get();
        }else {
            throw new RuntimeException("No record found for given id:"+id);
        }
        return group;
    }

    @Override
    public StudentGroup updateStudentGroup(StudentGroup group) {
        return studentGroupsDao.save(group);
    }

    @Override
    public void deleteStudentGroup(long id) {

    }

    public void deleteStudentGroup(Long id) {
        studentGroupsDao.deleteById(id);
    }
}
