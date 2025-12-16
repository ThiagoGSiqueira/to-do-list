package app.view.feedback;

import app.view.Colors;

public class TaskAlreadyDoneView {
    public void render() {
        System.out.println(Colors.ANSI_YELLOW + "Tarefa já concluida." +  Colors.ANSI_RESET);
    }
}
