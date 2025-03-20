package dao;
import models.User;
import util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public static boolean registerUser(User user){
        try{
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO users (name, email, password, age, gender, height, weight, goal) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getAge());
            stmt.setString(5, user.getGender());
            stmt.setDouble(6, user.getHeight());
            stmt.setDouble(7, user.getWeight());
            stmt.setString(8, user.getGoal());

            int rows = stmt.executeUpdate();
            return rows>0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //Login a user
    public static boolean loginUsers(String email , String password){
        try{
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();   //If user found , return true
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static User getUserByEmail(String email){
        try{
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getDouble("height"),
                    rs.getDouble("weight"),
                    rs.getString("goal")
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
