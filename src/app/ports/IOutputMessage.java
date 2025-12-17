package app.ports;

public interface IOutputMessage {
    void displaySuccess(String message);
    void displayError(String message);
    void displayWarning(String message);
}
