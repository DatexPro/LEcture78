package com.example.springmvc.service;

import com.example.springmvc.Dao.StudentsDao;
import com.example.springmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceI implements StudentService {
    @Autowired
    private StudentsDao studentsDao;

    @Override
    public void create(Student student) {
        studentsDao.save(student);
    }

    @Override
    public List<Student> readAll() {
        List<Student> allStudent = new ArrayList<>();
        Iterator<Student> studentIterator = studentsDao.findAll().iterator();
        while (studentIterator.hasNext()) {
            allStudent.add(studentIterator.next());
        }
        return allStudent;
    }

    @Override
    public List<Student> readAllStudentsByGroup(Long groupId) {
        return studentsDao.getStudentByGroupID(groupId);
    }


    @Override
    public Student read(long id) {
        return studentsDao.getOne(id);
    }

    @Override
    public boolean update(Student student, Long id) {
        if (studentsDao.existsById(id)){
            student.setId(id);
            studentsDao.save(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (studentsDao.existsById(id)){
            studentsDao.deleteById(id);
            return true;
        }
        return false;
    }

}
