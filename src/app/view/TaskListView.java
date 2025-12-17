package app.view;

import app.model.Task;
import app.ports.ITaskListView;

import java.util.List;

public class TaskListView implements ITaskListView {
    @Override
    public void display(List<Task> tasks) {
        for (Task task : tasks) {
            new TaskItemView().render(task);
            System.out.println("============");
        }
    }
}
