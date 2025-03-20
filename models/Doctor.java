package models;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String availability;
    private String contact;

    public Doctor(int id, String name, String specialization, String availability, String contact) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.contact = contact;
    }

    public Doctor(String name, String specialization , String availability, String contact){
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.contact = contact;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public String getAvailability(){
        return availability;
    }
    public void setAvailability(String availability){
        this.availability = availability;
    }
    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Specialization: " + specialization +
               ", Availability: " + availability + ", Contact: " + contact;
    }
}
