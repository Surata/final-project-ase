/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Controller.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;

/**
 *
 * @author edista
 */
public class GRZProduct {
    private int productID;
    private String name;
    private String description;
    private String price;
    private String image;
    private int count;

    public GRZProduct() {} // constructor
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    public ResultSet searchAll(ServletContext app){
        Connect con = new Connect(app);
        String query = "SELECT * FROM Products ORDER BY ID DESC";
        ResultSet rs = con.execute(query);
        
        return rs;
    }
    
    public ResultSet searchWithFilter(ServletContext app, int priceFilter){
        float minRange = getMinPrice(priceFilter);
        float maxRange = getMaxPrice(priceFilter);
  
        Connect con = new Connect(app);
        String query = "SELECT * FROM Products WHERE Price BETWEEN " + minRange + " AND " + maxRange;
        ResultSet rs = con.execute(query);
        
        return rs;
        
    }
    
    private float getMinPrice(int priceFilter){
        float minRange = 0;
        
        switch(priceFilter){
            case 0 : {
                minRange = 0;
            }break;
            case 1 : {
                minRange = 0;
            }break;
            case 2 : {
                minRange = 35000;
            }break;
            case 3 : {
                minRange = 70000;
            }break;
            case 4 : {
                minRange = 105000;
            }break;
            case 5 : {
                minRange = 140000;
            }
        }
        return minRange;
    }
    
    private float getMaxPrice(int priceFilter){
        float maxRange = 999999;
        
        switch(priceFilter){
            case 0 : {
                maxRange = 999999;
            }break;
            case 1 : {
                maxRange = 35000;
            }break;
            case 2 : {
                maxRange = 70000;
            }break;
            case 3 : {
                maxRange = 105000;
            }break;
            case 4 : {
                maxRange = 140000;
            }break;
            case 5 : {
                maxRange = 999999;
            }
        }
        return maxRange;
    }
    
    public ResultSet searchWithText(ServletContext app, String productName){
        Connect con = new Connect(app);
        String query = "SELECT * FROM Products WHERE Name LIKE '%" + productName +"%'";
        ResultSet rs = con.execute(query);
        
        return rs;
    }
    
    public ResultSet searchWithTextAndFilter(ServletContext app, String productName, int priceFilter){
        float minRange = getMinPrice(priceFilter);
        float maxRange = getMaxPrice(priceFilter);
        
        Connect con = new Connect(app);
        String query = "SELECT * FROM Products WHERE Name LIKE '%" + productName +"%' AND Price BETWEEN " + minRange 
                + " AND " + maxRange;
        ResultSet rs = con.execute(query);
        
        return rs;
    }
    
    public void insert(ServletContext app){
        Connect con = new Connect(app);
      
        String query = "INSERT INTO Products (Name, Description, Price, Image) "
                + "VALUES ('" + name + "','" + description + "','" + Float.parseFloat(price) + "','" + image + "')";

        con.Query(query);
        con.closeConnect();
      
    }
    
    public void update(ServletContext app){
        
    }
    
    public void delete(ServletContext app, int id){
        Connect con = new Connect(app);
        String query = "DELETE FROM Products WHERE ID =" + id;
        con.Query(query);
        con.closeConnect();
    }
    
    public int getRowCount(ResultSet rs) throws SQLException{
        int row =0;
        while(rs.next()){
            row++;
        }
        rs.beforeFirst();
        return row;
    }
    
}
