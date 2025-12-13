package exceptions;

public class TitleTooLongException extends RuntimeException {
    public TitleTooLongException(String message) {
        super(message);
    }
}
