package exceptions;

public class TaskAlreadyDoneException extends RuntimeException {
    public TaskAlreadyDoneException(String message) {
        super(message);
    }
}
