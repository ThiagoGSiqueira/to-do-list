package app.view.feedback;

import app.view.Colors;

public class EmptyListView {
    public void render() {
        System.out.println(Colors.ANSI_RED + "Nenhuma tarefa encontrada!" + Colors.ANSI_RESET);
    }
}
