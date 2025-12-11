package view;

import java.util.Scanner;

public class IdInputView {
    Scanner sc = new Scanner(System.in);
    public int getTaskId() {
        System.out.print("Digite o ID da tarefa: ");
        return sc.nextInt();
    }
}
