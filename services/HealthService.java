package services;

import dao.HealthDataDAO;
import models.HealthData;
import java.sql.Date;
import java.util.List;

public class HealthService {
    private HealthDataDAO healthDataDAO;

    public HealthService() {
        this.healthDataDAO = new HealthDataDAO();
    }

    public List<HealthData> getUserHealthData(int userId) {
        if (userId <= 0) {
            System.out.println("Invalid user ID!");
            return null; 
        }
        return healthDataDAO.fetchHealthData(userId);
    }

    public boolean addHealthData(int userId, int steps, int calories, int workouts) {
        if (userId <= 0 || steps < 0 || calories < 0 || workouts <0) {
            System.out.println("Invalid health data values!");
            return false;
        }

        HealthData healthData = new HealthData(userId, steps, calories, workouts, new Date(System.currentTimeMillis()));

        return healthDataDAO.insertHealthData(healthData);
    }
}
