/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumne
 */
public class ImageService {
    private Connection connection;
    private static final ImageService instance = new ImageService();
    
    public ImageService() {
        connection = null;
    }
    
    public static ImageService getInstance() {
        return instance;
    }
    
    public boolean imageRegister(Image image) 
            throws  IOException, SQLException {
        try {
            String query;
            PreparedStatement statement;
            initConnection();

            query = "insert into images "
                    + "(TITLE, DESCRIPTION, KEYWORDS, AUTHOR, UPLOADER, "
                    + "CAPTURE_DATE, STORAGE_DATE, FILENAME) "
                    + "values(?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);    
            statement.setString(1, image.getTitle());
            statement.setString(2, image.getDescription());
            statement.setString(3, image.getKeywords());
            statement.setString(4, image.getAuthor());
            statement.setString(5, image.getUploader());
            statement.setString(6, image.getCaptureDate()); 
            statement.setString(7, image.getStorageDate());
            statement.setString(8, image.getFileName());
                        
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
    
    public Image getImage(int id)
        throws  IOException, SQLException{
        try {
            Image im = null;
            String query;
            PreparedStatement statement;
            initConnection();

            query = "select * from images "
                    + "where id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                String title = rs.getString("title");
                String description = rs.getString("description");
                String keywords = rs.getString("keywords");
                String author = rs.getString("author");
                String uploader = rs.getString("uploader");
                String captureDate = rs.getString("capture_date");
                String storageDate = rs.getString("storage_date");
                String fileName = rs.getString("filename");
                
                im = new Image(title, description, keywords, author,
                uploader, captureDate, storageDate, fileName);
                im.setId(id);
            }
            return im;
        }
        catch(SQLException e) {
            return null;
        }
        finally {
            closeConnection();
        }
    }
    
    public List<Image> getImageList() 
            throws  IOException, SQLException {
        try {
            List<Image> list = new ArrayList<>();
            String query;
            PreparedStatement statement;
            initConnection();

            query = "select * from images";
            statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String keywords = rs.getString("keywords");
                String author = rs.getString("author");
                String uploader = rs.getString("uploader");
                String captureDate = rs.getString("capture_date");
                String storageDate = rs.getString("storage_date");
                String fileName = rs.getString("filename");
                
                Image im = new Image(title, description, keywords, author,
                uploader, captureDate, storageDate, fileName);
                im.setId(id);
                
                list.add(im);
            }
            return list;
        }
        catch(SQLException e) {
            return null;
        }
        finally {
            closeConnection();
        }
    }
    
        public List<Image> searchByTitle(String queryParams) 
            throws  IOException, SQLException {
        try {
            List<Image> list = new ArrayList<>();
            String query;
            queryParams =  queryParams.toLowerCase();
            PreparedStatement statement;
            initConnection();

            query = "select * from images "
                    + "where LOWER(title) LIKE ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, "%" + queryParams + "%");
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String keywords = rs.getString("keywords");
                String author = rs.getString("author");
                String uploader = rs.getString("uploader");
                String captureDate = rs.getString("capture_date");
                String storageDate = rs.getString("storage_date");
                String fileName = rs.getString("filename");
                
                Image im = new Image(title, description, keywords, author,
                uploader, captureDate, storageDate, fileName);
                im.setId(id);
                
                list.add(im);
            }
            return list;
        }
        catch(SQLException e) {
            return null;
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
