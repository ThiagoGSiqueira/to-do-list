package app.view;

import app.model.Task;

import java.util.List;

public class ListAllTasksView {
    public void render(List<Task> tasks) {
        for (Task task : tasks) {
            new TaskItemView().render(task);
            System.out.println("============");
        }
    }
}
