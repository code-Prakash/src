package dao;
import models.Order;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OrderDAO {
    public boolean addOrder(Order order){
        String sql = "INSERT INTO orders (user_id, product_id, quantity, order_date, status) VALUES (?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getProductId());
            pstmt.setInt(3, order.getQuantity());
            pstmt.setTimestamp(4,new Timestamp(order.getOrderDate().getTime()));
            pstmt.setString(5, order.getStatus());
            return pstmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public Order getOrderById(int userId){
        String sql = "SELECT * FORM order WHERE id = ? ";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return new Order(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("product_id"),
                    rs.getInt("quantity"),
                    rs.getTimestamp("order_date"),
                    rs.getString("status")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Order> getAllOrders(){
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            while(rs.next()){
                orders.add(new Order(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("product_id"),
                    rs.getInt("quantity"),
                    rs.getTimestamp("order_date"),
                    rs.getString("status")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return orders;
    }
    public boolean updateOrderStatus(int orderId , String status){
        String sql = "UPDATE orders SET status =? WHERE id =?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, status);
            pstmt.setInt(2, orderId);
            return pstmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteOrder(int id){
        String sql = "DELETE FROM orders WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            return pstmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
