package view.feedback;

import view.Colors;

public class EmptyListView {
    public void render() {
        System.out.println(Colors.ANSI_RED + "Nenhuma tarefa encontrada!" + Colors.ANSI_RESET);
    }
}
