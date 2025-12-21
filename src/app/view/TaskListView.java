package app.view;

import app.model.Task;
import app.ports.ITaskListView;
import app.util.DateFormatter;
import app.util.ViewUtils;

import java.util.List;
import java.util.Scanner;

public class TaskListView implements ITaskListView {
    @Override
    public void display(List<Task> tasks) {
        Scanner sc = new Scanner(System.in);
        ViewUtils.clear();
        System.out.println( Colors.ANSI_CYAN + "=== LISTA DE TAREFAS ===" + Colors.ANSI_RESET);
        for (Task task : tasks) {
            System.out.println("---------------");
            System.out.println("ID da tarefa: " + task.getIdTask());
            System.out.println("Título da tarefa: " + task.getTaskTitle());
            System.out.println("Status: " + task.getTaskStatus());
        }
        System.out.println("---------------");
        System.out.print("Digite enter para continuar");
        sc.nextLine();
    }
}
