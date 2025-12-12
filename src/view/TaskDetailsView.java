package view;

import model.Task;

public class TaskDetailsView {
    public void render(Task task) {
        System.out.println("Detalhes da tarefa: ");
        new TaskItemView().render(task);
    }
}
