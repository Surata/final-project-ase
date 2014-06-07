/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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
    private float price;
    private String image;
    private int count;

    public GRZProduct() {
    }
    
    public GRZProduct(int productID, String name, String description, float price, String image) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public GRZProduct(String name, String description, float price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }
    
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
