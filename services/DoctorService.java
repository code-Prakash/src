package services;
import dao.DoctorDAO;
import models.Doctor;
import java.util.List;
public class DoctorService {
    private DoctorDAO doctorDAO;

    public DoctorService() {
        this.doctorDAO = new DoctorDAO();
    }

    public boolean addNewDoctor(String name , String specialization , String availability , String contact){
        if(name.isEmpty() || specialization.isEmpty() || availability.isEmpty() || contact.isEmpty()){
            System.out.println("Invalid doctor details!");
            return false;
        }
        Doctor doctor = new Doctor(name, specialization , availability , contact);
        return doctorDAO.addDoctor(doctor);
    }
    public List<Doctor> fetchAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    public boolean modifyDoctor(int id, String name, String specialization, String availability, String contact) {
        return doctorDAO.updateDoctor(id, name, specialization, availability, contact);
    }

    public boolean removeDoctor(int id) {
        return doctorDAO.deleteDoctor(id);
    }
}
