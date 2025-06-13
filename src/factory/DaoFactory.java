package factory;

import dao.RepositoryDAO;
import dao.StudentDAOImpl;
import dao.SubjectDAOImpl;

public class DaoFactory {
    public static RepositoryDAO getDAO(String type){
        if(type.equalsIgnoreCase("student")){
            return new StudentDAOImpl();
        }else if(type.equalsIgnoreCase("subject")){
            return new SubjectDAOImpl();
        }
        throw new IllegalArgumentException("No DAO found");
    }
}