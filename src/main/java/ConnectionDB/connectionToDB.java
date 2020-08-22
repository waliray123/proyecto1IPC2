/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author user-ubunto
 */
public class connectionToDB {
    public static final String URL = "jdbc:mysql://localhost:3306/INTELAF?autoReconect=true&useSSL=false";//auto reconnect
    public static final String USER = "root";//a test user, u can use a personal user
    public static final String PASSWORD = "password123";//my password for the user

    public Connection getConnection() {
        Connection connection = null;//initialize
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//declare a driver
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);//we connect with the info            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR, " + e.getMessage(), "X", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
    
    
    
}
