package app.view;

import app.model.Task;
import app.ports.ITaskDetailsView;

public class TaskDetailsView implements ITaskDetailsView {
    @Override
    public void display(Task task) {
        System.out.println("Detalhes da tarefa: ");
        new TaskItemView().render(task);
    }
}
