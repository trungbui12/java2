package dao;

import database.Connector;
import entity.Subject;

import java.sql.*;
import java.util.ArrayList;

public class SubjectDAOImpl implements SubjectDAO {
    private final String table = "subjects";

    @Override
    public ArrayList<Subject> all() {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            Statement st = Connector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table);
            while (rs.next()) {
                Subject s = new Subject(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("hours"),
                        rs.getDouble("cost")
                );
                list.add(s);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public Subject findById(Integer id) {
        try {
            Statement st = Connector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table + " WHERE id=" + id);
            if (rs.next()) {
                return new Subject(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("hours"),
                        rs.getDouble("cost")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public Boolean create(Subject s) {
        try {
            String sql = "INSERT INTO subjects(name, hours, cost) VALUES (?, ?, ?)";
            PreparedStatement ps = Connector.getInstance().preparedStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getHours());
            ps.setDouble(3, s.getCost());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public Boolean update(Subject s) {
        try {
            String sql = "UPDATE subjects SET name=?, hours=?, cost=? WHERE id=?";
            PreparedStatement ps = Connector.getInstance().preparedStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getHours());
            ps.setDouble(3, s.getCost());
            ps.setInt(4, s.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            String sql = "DELETE FROM subjects WHERE id=?";
            PreparedStatement ps = Connector.getInstance().preparedStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
