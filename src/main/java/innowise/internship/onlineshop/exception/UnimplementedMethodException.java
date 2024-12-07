package innowise.internship.onlineshop.exception;

public class UnimplementedMethodException extends Exception {

    public UnimplementedMethodException() {
        super("This method has not been implemented yet.");
    }

    public UnimplementedMethodException(String message) {
        super(message);
    }

    public UnimplementedMethodException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnimplementedMethodException(Throwable cause) {
        super("This method has not been implemented yet.", cause);
    }
}
