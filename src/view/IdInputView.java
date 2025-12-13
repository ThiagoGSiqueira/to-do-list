package view;

import exceptions.TaskNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IdInputView {
    Scanner sc = new Scanner(System.in);
    public int getTaskId() {
        System.out.print("Digite o ID da tarefa: ");

        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw new TaskNotFoundException("O ID tem que ser um número. Tarefa não encontrada");
        }
    }
}
