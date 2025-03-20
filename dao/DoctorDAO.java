package dao;
import models.Doctor;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public boolean addDoctor(Doctor doctor){
        String sql = "INSERT INTO doctors (name, specialization, availability, contact) VALUES (?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, doctor.getName());
                pstmt.setString(2, doctor.getSpecialization());
                pstmt.setString(3, doctor.getAvailability());
                pstmt.setString(4, doctor.getContact());

                return pstmt.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Doctor> getAllDoctors(){
        String query = "SELECT * FROM doctors";
        List<Doctor> doctorList = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery()){
            while(rs.next()){
                doctorList.add(new Doctor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("specialization"),
                    rs.getString("availability"),
                    rs.getString("contact")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return doctorList;
    }

    //Update doctor details
    public boolean updateDoctor(int id, String name, String specialization , String availability , String contact){
        String sql = "UPDATE doctors SET name =?, specialization =?, availability =?, contact =? WHERE id =?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setString(2, specialization);
            pstmt.setString(3, availability);
            pstmt.setString(4, contact);
            pstmt.setInt(5, id);

            return pstmt.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //Delete doctor
    public boolean deleteDoctor(int id){
        String sql = "DELETE FROM doctors WHERE id =?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);

            return pstmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
