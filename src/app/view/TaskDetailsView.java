package app.view;

import app.model.Task;
import app.ports.ITaskDetailsView;
import app.util.DateFormatter;

public class TaskDetailsView implements ITaskDetailsView {
    @Override
    public void display(Task task) throws InterruptedException {
        System.out.println(Colors.ANSI_CYAN + "Detalhes da tarefa: " + Colors.ANSI_RESET);
        System.out.println("---------------");
        System.out.println("ID da tarefa: " + task.getIdTask());
        System.out.println("Título da tarefa: " + task.getTaskTitle());
        System.out.println("Descrição da tarefa: " + task.getTaskDescription());
        System.out.println("Status: " + task.getTaskStatus());
        System.out.println("Data de início: " + DateFormatter.format(task.getStartedAt()));
        System.out.println("Data de término: " + DateFormatter.format(task.getCompletedAt()));
        System.out.println("---------------");
    }
}
