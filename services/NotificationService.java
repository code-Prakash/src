package services;

import models.TaskTracker;
import dao.TaskTrackerDAO;
import java.time.LocalDateTime;
import java.util.List;

public class NotificationService {
    private TaskTrackerDAO taskDAO;

    public NotificationService(TaskTrackerDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void checkAndSendNotifications(int userId) {
        List<TaskTracker> tasks = taskDAO.getTaskByUser(userId);
        for (TaskTracker task : tasks) {
            if (task.getReminderTime().isBefore(LocalDateTime.now().plusMinutes(10)) &&
                task.getStatus().equals("Pending")) {
                System.out.println("Reminder: You have a task - " + task.getTask() + " at " + task.getReminderTime());
            }
        }
    }
}
