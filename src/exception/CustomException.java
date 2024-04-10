package exception;

public class CustomException extends Exception {
    /**
     * This can be used in main as
     * //throw new CustomException("This is my custom exception.");
     *
     * @param message
     */
    public CustomException(String message) {
        super(message);
    }
}
