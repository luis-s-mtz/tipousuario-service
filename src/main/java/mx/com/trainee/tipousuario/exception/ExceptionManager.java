package mx.com.trainee.tipousuario.exception;

import lombok.extern.slf4j.Slf4j;
import mx.com.trainee.tipousuario.exception.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * @author luis
 * @since 1.0
 *
 * Class used to manage the exceptions throw in the tipousuario-service.
 */
@Slf4j
@ControllerAdvice
public class ExceptionManager {

    /**
     * Default message value related to {@code ItemNotFoundException} when the information is not found.
     */
    private static final String MESSAGE_NOT_FOUND = "Item(s) not found: ";
    /**
     * Constant value with the name of class {@code ItemNotFoundException} that throws the error HTTP 404 when information
     * is not found.
     */
    private static final String NOTFOUND_EXPT_CLASSNAME = "ItemNotFoundException";
    /**
     * Default message value related to {@code UsrTypInteralServerErrorException} when error in business layer is throw.
     */
    private static final String MESSAGE_INTERNAL_SERV_ERR = "Internal Server Error: ";
    /**
     * Constant value with the name of class {@code UsrTypInteralServerErrorException} that throws the error HTTP 500
     * when error in business layer is throw.
     */
    private static final String INTERNALSERVERR_EXPT_CLASSNAME = "PermisoSrvInternalServErrorException";


    /**
     * Value of the property that describe the path of the service on which throw the exception.
     */
    @Value("${tipousuario.api.path}")
    private String userTypeApiPath;

    /**
     * Method used to manage the exception {@code ItemNotFoundException} when the query not contains coincidences.
     * @param ex The Exception throw in the service.
     * @return The response with ErrorDTO object filled with information about the exception.
     */
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> manageNotFoundException(ItemNotFoundException ex) {
        log.error("Error [{}]: {}",NOTFOUND_EXPT_CLASSNAME,ex.getMessage());
        ErrorDTO error = buildErrorMessage(
                HttpStatus.NOT_FOUND.value(),MESSAGE_NOT_FOUND,ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Method used to manage the exception {@code UsrTypInteralServerErrorException} when the database throw a exception.
     * @param ex The Exception throws in the service.
     * @return The response with ErrorDTO object filled with information about the exception.
     */
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> manageInteranlServErrorExcpt(UsrTypInteralServerErrorException ex) {
        log.error("Error [{}]: {}",INTERNALSERVERR_EXPT_CLASSNAME,ex.getMessage());
        ErrorDTO error = buildErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),MESSAGE_INTERNAL_SERV_ERR,ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Method to create a ErrorDTO using the message of the exception error.
     * @param status The HTTP error code.
     * @param error The error description related the exception throw in business layer.
     * @param message The detail of error in related the core exception if exist.
     * @return
     */
    private ErrorDTO buildErrorMessage(int status, String error, String message) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(status);
        errorDTO.setTimestamp(LocalDateTime.now());
        errorDTO.setPath(userTypeApiPath);
        errorDTO.setError(error.concat(message));

        return errorDTO;
    }
}
