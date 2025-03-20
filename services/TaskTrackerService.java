package services;

import dao.TaskTrackerDAO;
import models.TaskTracker;
import java.time.LocalDateTime;
import java.util.List;
public class TaskTrackerService {
    private TaskTrackerDAO taskDAO;
    
    public TaskTrackerService(TaskTrackerDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public boolean createTask(int userId, String task, LocalDateTime reminderTime) {
        TaskTracker newTask = new TaskTracker(0, userId, task, reminderTime, "Pending");
        return taskDAO.addTask(newTask);
    }

    public List<TaskTracker> getUserTasks(int userId) {
        return taskDAO.getTaskByUser(userId);
    }

    public boolean completeTask(int taskId) {
        return taskDAO.updateTasksStatus(taskId, "Completed");
    }
}
