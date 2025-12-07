package model;

import enums.TaskStatus;

import java.time.LocalDateTime;

public class Task {
    private int idTask;
    private String taskTitle;
    private String taskDescription;
    private LocalDateTime startedAt;
    private TaskStatus taskStatus;
    private LocalDateTime completedAt;

    public Task(String taskTitle, String taskDescription) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.startedAt = LocalDateTime.now();
        this.taskStatus = TaskStatus.PENDING;
        this.completedAt = null;
    }

    public Task(String taskTitle, String taskDescription, int idTask) {
        this(taskTitle, taskDescription);
        this.idTask = idTask;
    }

    public void maskAsDone() {
        this.taskStatus = TaskStatus.DONE;
        this.completedAt = LocalDateTime.now();
    }


    public int getIdTask() {
        return idTask;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
