package models;
import java.time.LocalDateTime;

public class TaskTracker {
    private int id;
    private int userId;
    private String task;
    private LocalDateTime reminderTime;
    private String status;

    public TaskTracker(int id, int userId, String task, LocalDateTime reminderTime, String status) {
        this.id = id;
        this.userId = userId;
        this.task = task;
        this.reminderTime = reminderTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public LocalDateTime getReminderTime() {
        return reminderTime;
    }
    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String toString() {
        return "TaskTracker{" +
                "id=" + id +
                ", userId=" + userId +
                ", task='" + task + '\'' +
                ", reminderTime=" + reminderTime +
                ", status='" + status + '\'' +
                '}';
    }

}
