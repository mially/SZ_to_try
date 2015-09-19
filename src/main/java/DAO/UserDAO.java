package DAO;

import models.User;

import java.sql.*;

public class UserDAO {

    String dbURL = "jdbc:mysql://localhost:3306/zubrikdb";
    String username = "root";
    String password = "";
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
        String sql = "SELECT * FROM Users WHERE username = " + username;
        User user = new User();

        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                user.setId(result.getString(1));
                user.setUsername(result.getString(2));
                user.setPassword(result.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
