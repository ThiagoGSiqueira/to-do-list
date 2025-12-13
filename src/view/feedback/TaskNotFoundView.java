package view.feedback;

import view.Colors;

public class TaskNotFoundView {
    public void render() {
        System.out.println(Colors.ANSI_RED + "Tarefa não encontrada." + Colors.ANSI_RESET);
    }
}
