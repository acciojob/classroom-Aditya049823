package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student)
    {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addPair(String student, String teacher) {
        studentRepository.addPair(student,teacher);
    }

    public Student findStudentbyName(String name) {
        return studentRepository.getStudent(name);
    }

    public Teacher findTeacherbyName(String name) {
        return studentRepository.getTeacher(name);
    }

    public List<String> getStudentsbyTeacherName(String teacher) {
        return studentRepository.getStudentNamethroughTeacher(teacher);
    }

    public List<String> findAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherEntry(String teacher) {
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
