package models;
import java.util.Date;
public class Order {
    private int id;
    private int userId;
    private int productId;
    private int quantity;
    private Date orderDate;
    private String status;

    public Order(int id, int userId, int productId, int quantity, Date orderDate, String status) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Order ID: " + id + ", User ID: " + userId + ", Product ID: " + productId + ", Quantity: " + quantity + ", Order Date: " + orderDate + ", Status: " + status;
    }
}
