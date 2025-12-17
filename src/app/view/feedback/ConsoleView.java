package app.view.feedback;

import app.ports.IOutputMessage;
import app.view.Colors;

public class ConsoleView implements IOutputMessage {
    @Override
    public void displaySuccess(String message) {
        System.out.println(Colors.ANSI_GREEN + "SUCESSO: " + message + Colors.ANSI_RESET);
    }

    @Override
    public void displayError(String message) {
        System.out.println(Colors.ANSI_RED + "ERRO: " + message + Colors.ANSI_RESET);
    }

    @Override
    public void displayWarning(String message) {
        System.out.println(Colors.ANSI_YELLOW + "AVISO: " + message + Colors.ANSI_RESET);
    }
}
