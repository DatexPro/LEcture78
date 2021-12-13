package com.example.springmvc.service;

import com.example.springmvc.Dao.StudentsDao;
import com.example.springmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceI implements StudentService {

    private StudentsDao studentsDao;

    @Autowired
    public StudentServiceI(StudentsDao studentsDao) {
        this.studentsDao = studentsDao;
    }

    @Override
    public void saveStudent(Student student) {
        studentsDao.save(student);
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> allStudent = new ArrayList<>();
        Iterator<Student> studentIterator = studentsDao.findAll().iterator();
        while (studentIterator.hasNext()) {
            allStudent.add(studentIterator.next());
        }
        return allStudent;
    }

    @Override
    public List<Student> getAllStudentsByGroup(long groupId) {
        return studentsDao.getStudentByGroupID(groupId);
    }


    @Override
    public Student getStudent(long id) {
        Optional<Student> students = studentsDao.findById(id);
        Student student = null;
        if (students.isPresent()) {
            student = students.get();
        } else {
            throw new RuntimeException("No record found for given id:" + id);
        }
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        return studentsDao.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentsDao.deleteById(id);
    }
}
