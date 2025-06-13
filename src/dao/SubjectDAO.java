package dao;

import entity.Subject;
import java.util.ArrayList;

public interface SubjectDAO {
    ArrayList<Subject> all();
    Subject findById(Integer id);
    Boolean create(Subject s);
    Boolean update(Subject s);
    Boolean delete(Integer id);
}
