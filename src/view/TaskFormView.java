package view;

import model.Task;

import java.util.Scanner;

public class TaskFormView {
    Scanner sc = new Scanner(System.in);
    public Task render(){
        System.out.print("Digite o título da sua tarefa: ");
        String taskTitle = sc.nextLine();
        System.out.print("Digite a descrição da sua tarefa: ");
        String taskDescription = sc.nextLine();

        return new Task(taskTitle, taskDescription);
    }
}
