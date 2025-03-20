package dao;
import models.TaskTracker;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskTrackerDAO {
    public boolean addTask(TaskTracker task){
        String query = "INSERT INTO task_tracker(user_id , task , remainder_time , status) VALURS(?, ? , ? ,? )";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, task.getUserId());
            pstmt.setString(2, task.getTask());
            pstmt.setTimestamp(3, Timestamp.valueOf(task.getReminderTime()));
            pstmt.setString(4, task.getStatus());
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<TaskTracker> getTaskByUser(int userId){
        List<TaskTracker> tasks = new ArrayList<>();
        String query = "SELECT * FROM task_tracker WHERE user_id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1,userId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                tasks.add(new TaskTracker(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("task"),
                    rs.getTimestamp("remainder_time").toLocalDateTime(),
                    rs.getString("status")
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public boolean updateTasksStatus(int taskId, String status){
        String query = "UPDATE task_tracker SET status =? WHERE id =?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setString(1, status);
            pstmt.setInt(2, taskId);
            return pstmt.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
