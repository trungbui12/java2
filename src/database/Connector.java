package database;

import java.sql.*;

public class Connector {
    private String connectionString = "jdbc:mysql://localhost:3306/t2409m_jp";
    private String username = "root";
    private String password = "root";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection conn;
    private static Connector instance;
    private Connector() {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(connectionString,username,password);
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }
    public static Connector getInstance(){
        if(instance == null){
            instance = new Connector();
        }
        return instance;
    }

    public Statement createStatement() throws SQLException {
        return conn.createStatement();
    }

    public PreparedStatement preparedStatement(String sql) throws SQLException{
        return conn.prepareStatement(sql);
    }
}