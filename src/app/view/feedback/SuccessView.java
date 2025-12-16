package app.view.feedback;

import app.view.Colors;

public class SuccessView {
    public void render(int idTask, String message) {
        System.out.println(Colors.ANSI_GREEN + "SUCESSO: " + message + " ID: " + idTask + Colors.ANSI_RESET);
    }
}
