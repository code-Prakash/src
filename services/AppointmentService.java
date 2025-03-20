package services;
import dao.AppointmentDAO;
import models.Appointment;

import java.sql.Timestamp;
import java.util.List;

public class AppointmentService {
    private AppointmentDAO appointmentDAO;
    public AppointmentService() {
        this.appointmentDAO = new AppointmentDAO();
    }

    //Book appointment
    public boolean bookAppointment(int userId, int doctorId, Timestamp dateTime) {
        return appointmentDAO.insertAppointment(new Appointment(0, userId, doctorId, dateTime, "Pending"));
    }

    //get user appoinment
    public List<Appointment> getUserAppointments(int userId) {
        return appointmentDAO.getAppointmentsByUserId(userId);
    }

    //cancel appoitment
    public boolean cancelAppointment(int appointmentId) {
        return appointmentDAO.cancelAppointment(appointmentId);
    }

    //get doctor's appointment
    public List<Appointment> getDoctorAppointments(int doctorId) {
        return appointmentDAO.getAppointmentsByDoctorId(doctorId);
    }

}
