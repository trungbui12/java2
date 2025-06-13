package dao;

import database.Connector;
import entity.Result;

import java.sql.*;
import java.util.ArrayList;

public class ResultDAOImpl implements ResultDAO {
    private String table = "results";

    @Override
    public ArrayList<Result> all() {
        ArrayList<Result> list = new ArrayList<>();
        try {
            Statement stmt = Connector.getInstance().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
            while (rs.next()) {
                list.add(new Result(
                    rs.getInt("id"),
                    rs.getDouble("mark"),
                    rs.getInt("student_id"),
                    rs.getInt("subject_id")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public Result findById(Integer id) {
        try {
            Statement stmt = Connector.getInstance().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE id=" + id);
            if (rs.next()) {
                return new Result(
                    rs.getInt("id"),
                    rs.getDouble("mark"),
                    rs.getInt("student_id"),
                    rs.getInt("subject_id")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public Boolean create(Result r) {
        try {
            String sql = "INSERT INTO " + table + " (mark, student_id, subject_id) VALUES (?, ?, ?)";
            PreparedStatement ps = Connector.getInstance().preparedStatement(sql);
            ps.setDouble(1, r.getMark());
            ps.setInt(2, r.getStudentId());
            ps.setInt(3, r.getSubjectId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public Boolean update(Result r) {
        try {
            String sql = "UPDATE " + table + " SET mark=?, student_id=?, subject_id=? WHERE id=?";
            PreparedStatement ps = Connector.getInstance().preparedStatement(sql);
            ps.setDouble(1, r.getMark());
            ps.setInt(2, r.getStudentId());
            ps.setInt(3, r.getSubjectId());
            ps.setInt(4, r.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            String sql = "DELETE FROM " + table + " WHERE id=?";
            PreparedStatement ps = Connector.getInstance().preparedStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
