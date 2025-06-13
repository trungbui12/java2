package dao;

import java.util.ArrayList;

import entity.Student;

public interface StudentDAO {
    ArrayList<Student> all(); //select * from student
    Student findById(Integer id);
    Boolean create(Student s); //insert into...
    Boolean update(Student s);// update students set....
    Boolean delete(Integer id);// delete from...
}
