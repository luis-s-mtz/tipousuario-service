package mx.com.trainee.tipousuario.exception;

/**
 * @author luis
 * @since 1.0
 * Class to define the InternalServerErrorException used in the exception manager of the service.
 */
public class UsrTypInteralServerErrorException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public UsrTypInteralServerErrorException(String message) {
        super(message);
    }
}
