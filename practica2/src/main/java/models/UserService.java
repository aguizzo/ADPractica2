/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import models.User;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author alumne
 */
public class UserService {
    private Connection connection;
    private static final UserService instance = new UserService();
    
    public UserService() {
        connection = null;
    }
    
    public static UserService getInstance() {
        return instance;
    }
    //Comprueba si el usuario está en la base de datos
    public boolean userLogin(User user) 
            throws  IOException, SQLException {
        try {
            String query;
            PreparedStatement statement;
            initConnection();

            query = "select * from users " +
                        "where username= ? and password= ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();    
         
            if (!rs.next()) {
                return false;
            }
            return true;
        }
        catch(SQLException e) {
            return false;
        }
        finally {
            closeConnection();
        }
    }
    
    public boolean userRegister(String username, String password) 
            throws  IOException, SQLException {
        try {
            String query;
            PreparedStatement statement;
            initConnection();

            query = "insert into users values(?,?)";
            statement = connection.prepareStatement(query);    
            statement.setString(1, username);
            statement.setString(2, password);
            int result = statement.executeUpdate();   
         
            if (result == 0) {
                return false;
            }
            return true;
        }
        catch(SQLException e) {
            return false;
        }
        finally {
            closeConnection();
        }
    }
    
    private void initConnection() throws IOException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void closeConnection() throws IOException {
        try {
            if (connection != null) {
                connection.close();
            }
        } 
        catch (Exception e) {
            // connection close failed.
            System.err.println(e.getMessage());
         }
    }
}
