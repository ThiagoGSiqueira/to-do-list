package app.view;

import app.model.Task;
import app.util.ViewUtils;

import java.util.Scanner;

public class TaskFormView {
    Scanner sc = new Scanner(System.in);
    public Task render(){
        System.out.print("Digite o título da sua tarefa: ");
        String taskTitle = sc.nextLine();
        System.out.print("Digite a descrição da sua tarefa: ");
        String taskDescription = sc.nextLine();
        ViewUtils.delay(500);
        ViewUtils.clear();
        return new Task(taskTitle, taskDescription);
    }
}
