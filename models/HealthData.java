package models;

import java.sql.Date;

public class HealthData {
    private int userId;
    private int steps;
    private int calories;
    private int workouts;
    private Date date; 

    public HealthData(int userId, int steps, int calories, int workouts, Date date) {
        this.userId = userId;
        this.steps = steps;
        this.calories = calories;
        this.workouts = workouts;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSteps() {
        return steps;
    }
    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getWorkouts() {
        return workouts;
    }
    public void setWorkouts(int workouts) {
        this.workouts = workouts;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Steps: " + steps + ", Calories Burned: " + calories + ", Workouts: " + workouts;
    }

}
