package app.exceptions;

public class DataAcessException extends RuntimeException {
    public DataAcessException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataAcessException(String message) {
        super(message);
    }
}
