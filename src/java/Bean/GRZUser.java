/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Controller.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author edista
 */
public class GRZUser {
    private int userID;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String status;
    
    public GRZUser() {} // constructor
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public ResultSet searchAll(ServletContext app){
        Connect con = new Connect(app);
        String query = "SELECT * FROM Users";
        ResultSet rs = con.execute(query);
        
        return rs;
    }
    
    public ResultSet searchForUser(ServletContext app, String username, String password){
        Connect con = new Connect(app);
        String query = "SELECT * FROM Users WHERE Username = '" + username + "'AND Password = '" + password + "'";
        ResultSet rs = con.execute(query);
        
        return rs;
        
    }
    
    public ResultSet searchForUsername(ServletContext app, String username){
        Connect con = new Connect(app);
        String query = "SELECT * FROM Users WHERE Username='" + username + "'";
        ResultSet rs = con.execute(query);
        
        return rs;
    }
    
    public void insert(ServletContext app){
        Connect con = new Connect(app);
      
        String query = "INSERT INTO Users (Username, Password, Name, Phone, Email, Address, Status) "
                + "VALUES ('" + username + "','" + password + "','" + name + "','" + phone + "','" + email 
                + "','" + address + "','" +  status + "')";

        con.Query(query);
        con.closeConnect();
      
    }
    
    public void update(ServletContext app){
        
    }
    
    public void delete(ServletContext app, int id){
        Connect con = new Connect(app);
        String query = "DELETE FROM Users WHERE ID =" + id;
        con.Query(query);
        con.closeConnect();
    }
    
    
}
