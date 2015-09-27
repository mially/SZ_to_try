package DAO;

import models.User;

import java.sql.*;

public class UserDAO {

    String dbURL = "jdbc:mysql://localhost:3306/sampledb";
    String username = "root";
    String password = " newpwd ";
    Connection conn = null;

    public void connect(){
        try {
            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection(){
        return conn;
    }

    public void createUser(String username, String password) {
        String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String username) {
        User user = new User();

        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE username = ?");

            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                user.setId(result.getString("id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
