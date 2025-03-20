package services;

import dao.OrderDAO;
import dao.ProductDAO;
import models.Order;
import models.Product;
import java.util.List;

public class ECommerceService {
    private OrderDAO orderDAO;
    private ProductDAO productDAO;


    // Add new product
    public boolean addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    // Get product by ID
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    // Place a new order
    public boolean placeOrder(Order order) {
        // Check if product exists and stock is available
        Product product = productDAO.getProductById(order.getProductId());
        if (product != null && product.getStock() >= order.getQuantity()) {
            // Deduct stock using the new updateProductStock method
            boolean isStockUpdated = productDAO.updateProductStock(order.getProductId(), product.getStock() - order.getQuantity());
            
            if (isStockUpdated) {
                return orderDAO.addOrder(order);
            }
        }
        return false;
    }

    // Get order by ID
    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    // Update order status
    public boolean updateOrderStatus(int orderId, String status) {
        return orderDAO.updateOrderStatus(orderId, status);
    }

    // Delete order
    public boolean deleteOrder(int orderId) {
        return orderDAO.deleteOrder(orderId);
    }
}
