package view;

import enums.TaskOptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    public static final Scanner sc = new Scanner(System.in);

    public TaskOptions render() {
        System.out.println("1 - Criar nova tarefa.");
        System.out.println("2 - Atualizar tarefa.");
        System.out.println("3 - Buscar tarefas");
        System.out.println("4 - Buscar tarefa por ID.");
        System.out.println("5 - Remover tarefa.");
        System.out.println("6 - Completar tarefa");

        try {
            int choice = sc.nextInt();
            return switch (choice) {
                case 1 -> TaskOptions.CREATE_TASK;
                case 2 -> TaskOptions.UPDATE_TASK;
                case 3 -> TaskOptions.FIND_ALL_TASKS;
                case 4 -> TaskOptions.FIND_TASK_BY_ID;
                case 5 -> TaskOptions.REMOVE_TASK;
                case 6 -> TaskOptions.COMPLETE_TASK;
                default -> {
                    System.out.println("Escolha uma opção válida.");
                    yield TaskOptions.INVALID_OPTION;
                }
            };
        } catch (InputMismatchException e) {
            System.out.println("Escolha uma opção válida.");
            sc.nextLine();
            return TaskOptions.INVALID_OPTION;
        }
    }
}
