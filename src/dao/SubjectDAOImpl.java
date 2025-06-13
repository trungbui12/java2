package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.security.auth.Subject;

import database.Connector;

public class SubjectDAOImpl implements RepositoryDAO<Subject,Integer>{

    @Override
    public ArrayList<Subject> all() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean create(Subject data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            Connector connector = Connector.getInstance();
            String sql = "DELETE FROM subjects WHERE id = ?";
            PreparedStatement pstm = connector.preparedStatement(sql);
            pstm.setInt(1, id);

            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi ra để debug
        }
        return false;
    }

    @Override
    public Subject findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean update(Subject data) {
        // TODO Auto-generated method stub
        return null;
    }
    

}
