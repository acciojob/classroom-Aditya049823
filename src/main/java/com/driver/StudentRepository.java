package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

        HashMap<String,Student> studentMap= new HashMap<>();
        HashMap<String,Teacher> teacherMap= new HashMap<>();
        HashMap<String, List<String>>studentTeacherMap = new HashMap<>();

    public void addStudent(Student student) {
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }

    public void addPair(String student, String teacher) {
       List<String>list=new ArrayList<>();
        if(studentTeacherMap.containsKey(teacher))
       {
           list=studentTeacherMap.get(teacher);
           list.add(student);
           studentTeacherMap.put(teacher,list);
       }
        else
        {
            list.add(student);
            studentTeacherMap.put(teacher,list);
        }
    }

    public Student getStudent(String name) {
       return studentMap.get(name);
    }

    public Teacher getTeacher(String name) {
        return teacherMap.get(name);
    }

    public List<String> getStudentNamethroughTeacher(String teacher) {
        List<String>sname=new ArrayList<>();
        for(String s:studentTeacherMap.keySet())
        {
            sname=studentTeacherMap.get(teacher);
        }
        return sname;
    }


    public List<String> getAllStudents() {
        List<String>ans=new ArrayList<>();
        for(String sname:studentMap.keySet())
        {
            ans.add(sname);
        }
        return ans;
    }

    public void deleteTeacher(String teacher) {
        List<String>deletelist=new ArrayList<>();
        if(studentTeacherMap.containsKey(teacher))
        {
            deletelist=studentTeacherMap.get(teacher);
            for(String sname:deletelist)
            {
                if(studentMap.containsKey(sname))
                {
                    studentMap.remove(sname);
                }
            }
            if(teacherMap.containsKey(teacher))
            {
                teacherMap.remove(teacher);
            }
            studentTeacherMap.remove(teacher);
        }
    }

    public void deleteAllTeachers() {
        teacherMap=new HashMap<>();
        HashSet<String>studentSet=new HashSet<>();
        for(String tname:studentTeacherMap.keySet())
        {
            for(String sname:studentTeacherMap.keySet())
            {
                studentSet.add(sname);
            }
        }
        for(String sname:studentSet)
        {
            if(studentMap.containsKey(sname))
            {
                studentMap.remove(sname);
            }
        }
        studentTeacherMap=new HashMap<>();
    }
}
