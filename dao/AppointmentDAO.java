package dao;
import models.Appointment;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AppointmentDAO {
    public boolean insertAppointment(Appointment appointment){
        String sql = "INSERT INTO appointments (user_id , doctor_id , date_time , status) VALUES(?,?,?,?,)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, appointment.getUserId());
            pstmt.setInt(2, appointment.getDoctorId());
            pstmt.setTimestamp(3, appointment.getDateTime());
            pstmt.setString(4, appointment.getStatus());

            return pstmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
        
    }

    // Get Appointment by User ID
    public List<Appointment> getAppointmentsByUserId(int userId){
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE user_id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                appointments.add(new Appointment(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("doctor_id"),
                    rs.getTimestamp("date_time"),
                    rs.getString("status")
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return appointments;
    }

    //cancel appointment
    public boolean cancelAppointment(int appointmentId) {
        String sql = "UPDATE appointments SET status = 'Cancelled' WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, appointmentId);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Get Appointment by DoctorId
    public List<Appointment> getAppointmentsByDoctorId(int doctorId){
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE doctor_id =?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1,doctorId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                appointments.add(new Appointment(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("doctor_id"),
                    rs.getTimestamp("date_time"),
                    rs.getString("status")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return appointments;
    }
}
