/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author edista
 */
public class GRZOrder {
    private int orderID;
    private int transactionID;
    private int productID;
    private int quantity;
    private float subTotal;

    public GRZOrder() {
    }

    public GRZOrder(int productID, int quantity, float subTotal, int transactionID) {
        this.productID = productID;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.transactionID = transactionID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int cartID) {
        this.transactionID = cartID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

}
