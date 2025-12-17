package app.ports;

import app.model.Task;

import java.util.List;

public interface ITaskListView {
    void display(List<Task> tasks);
}
