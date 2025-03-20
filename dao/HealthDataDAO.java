package dao;
import models.HealthData;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HealthDataDAO {
    public List<HealthData> fetchHealthData(int userId) {
        String query = "SELECT steps, calories, workouts, date FROM health_data WHERE user_id = ?";
        List<HealthData> statsList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                statsList.add(new HealthData(
                    userId,
                    rs.getInt("steps"),
                    rs.getInt("calories"),
                    rs.getInt("workouts"), 
                    rs.getDate("date")     
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statsList;
    }

    public boolean insertHealthData(HealthData healthData) {
        String query = "INSERT INTO health_data (user_id, steps, calories, workouts, date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, healthData.getUserId());
            pstmt.setInt(2, healthData.getSteps());
            pstmt.setInt(3, healthData.getCalories());
            pstmt.setInt(4, healthData.getWorkouts()); 
            pstmt.setDate(5, healthData.getDate()); 

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
