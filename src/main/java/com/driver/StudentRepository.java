package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    private HashMap<String,Student> studentMap;
    private HashMap<String,Teacher> teacherMap;
    private HashMap<String, List<String>>studentTeacherMap;

    public StudentRepository() {
        this.studentMap = new HashMap<>();
        this.teacherMap = new HashMap<>();
        this.studentTeacherMap = new HashMap<>();
    }

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
        for(String sname:studentMap.keySet())
        {
            if(sname.equals(name))
            {
                return studentMap.get(name);
            }
        }
        return null;
    }

    public Teacher getTeacher(String name) {
        for(String tname:teacherMap.keySet())
        {
            if(tname.equals(name))
            {
                teacherMap.get(name);
            }
        }
        return null;
    }

    public List<String> getStudentNamethroughTeacher(String teacher) {
        List<String>sname=new ArrayList<>();
        if(studentTeacherMap.containsKey(teacher))
        {
            return studentTeacherMap.get(teacher);
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
        List<String>list=new ArrayList<>();
        if(studentTeacherMap.containsKey(teacher))
        {
            list=studentTeacherMap.get(teacher);
            for(String sname:list)
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
        teacherMap.clear();
    }
}
