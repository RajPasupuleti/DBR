package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
  static private Connection conn;
  static private String connectionUrl = "jdbc:mysql://localhost:3306/DogBiteVictimRegistry";
  static private String userName = "root";
  static private String password = "12345";

  static Connection makeConnection() {
    if (conn == null) {
      try {
        conn = DriverManager.getConnection(connectionUrl, userName, password);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return conn;
  }

  static void closeConnection() { // Added closing parenthesis
    try {
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}