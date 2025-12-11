package view;

import enums.TaskOptions;
import enums.TaskStatus;

import java.util.Scanner;

public class MenuView {
    Scanner sc = new Scanner(System.in);

    public TaskOptions run() {
        System.out.println("1 - Criar nova tarefa.");
        System.out.println("2 - Atualizar tarefa.");
        System.out.println("3 - Buscar tarefas");
        System.out.println("4 - Buscar tarefa por ID.");
        System.out.println("5 - Remover tarefa.");
        System.out.println("6 - Completar tarefa");

        int choice = sc.nextInt();
        return switch (choice) {
            case 1 -> TaskOptions.CREATE_TASK;
            case 2 -> TaskOptions.UPDATE_TASK;
            case 3 -> TaskOptions.FIND_ALL_TASKS;
            case 4 -> TaskOptions.FIND_TASK_BY_ID;
            case 5 -> TaskOptions.REMOVE_TASK;
            case 6 -> TaskOptions.COMPLETE_TASK;
            default -> {
                System.out.println("Opção inválida.");
                yield null;
            }
        };
    }
}
