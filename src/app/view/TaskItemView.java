package app.view;

import app.model.Task;

public class TaskItemView {
    public void render(Task task) {
        System.out.println(task.getIdTask());
        System.out.println(task.getTaskTitle());
        System.out.println(task.getTaskDescription());
        System.out.println(task.getTaskStatus());
        System.out.println(task.getStartedAt());
        System.out.println(task.getCompletedAt());
    }
}
