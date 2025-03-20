package dao;

import models.Product;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductDAO {
    public  boolean addProduct(Product product){
        String sql = "INSERT INTO products (product_name, price, category, stock, description) VALUES (?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, product.getProductName());
                pstmt.setDouble(2, product.getPrice());
                pstmt.setString(3, product.getCategory());
                pstmt.setInt(4, product.getStock());
                pstmt.setString(5, product.getDescription());
                return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> getAllProducts(){
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String productName = rs.getString("product_name");
                    double price = rs.getDouble("price");
                    String category = rs.getString("category");
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    products.add(new Product(id, productName, price, category, stock, description));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int id){
        String sql = "SELECT * FROM products WHERE id =?";
        Product product = null;
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    rs.getInt("id");
                    rs.getString("product_name");
                    rs.getDouble("price");
                    rs.getString("category");
                    rs.getInt("stock");
                    rs.getString("description");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public boolean updateProduct(Product product){
        String sql = "UPDATE products SET product_name =?, price =?, category =?, stock =?, description =? WHERE id =?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, product.getProductName());
                pstmt.setDouble(2, product.getPrice());
                pstmt.setString(3, product.getCategory());
                pstmt.setInt(4, product.getStock());
                pstmt.setString(5, product.getDescription());
                pstmt.setInt(6, product.getId());
                return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProduct(int id) {
        String sql = "DELETE FROM ecommerce WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateProductStock(int productId, int newStock) {
        String query = "UPDATE ecommerce SET stock = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, newStock);
            stmt.setInt(2, productId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
