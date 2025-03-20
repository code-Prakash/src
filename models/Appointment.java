package models;
import java.sql.Timestamp;
public class Appointment {
    private int id;
    private int userId;
    private int doctorId;
    private Timestamp dateTime;
    private String status;

    public Appointment(int id , int userId , int doctorId , Timestamp dateTime , String status){
        this.id = id;
        this.userId = userId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.status = status;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getDoctorId(){
        return doctorId;
    }
    public void setDoctorId(int doctorId){
        this.doctorId = doctorId;
    }
    public Timestamp getDateTime(){
        return dateTime;
    }
    public void setDateTime(Timestamp dateTime){
        this.dateTime = dateTime;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id + ", User ID: " + userId + ", Doctor ID: " + doctorId + ", Date & Time: " + dateTime + ", Status: " + status;
    }
}
