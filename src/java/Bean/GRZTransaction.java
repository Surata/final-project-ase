/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author edista
 */
public class GRZTransaction {
    private int transactionID;
    private int userID;
    private float total;
    private int status;
    private String date;

    public GRZTransaction() {
    }

    public GRZTransaction(int userID, float total, int status, String date) {
        this.userID = userID;
        this.total = total;
        this.status = status;
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int cartID) {
        this.transactionID = cartID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public void addToTotal(float subTotal){
        this.total += subTotal;
    }
}
