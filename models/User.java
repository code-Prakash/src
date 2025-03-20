package models;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private String goal;

    public User(int id, String name, String email, String password, int age, String gender, double height, double weight, String goal) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getGoal() {
        return goal;
    }
    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + 
                ", email='" + email + 
                ", age=" + age +
                ", gender='" + gender + 
                ", height=" + height +
                ", weight=" + weight +
                ", Goal='" + goal +
                '}';
    }

}
