package mx.com.trainee.tipousuario.exception.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author luis
 * @since 1.0
 *
 * Class ErrorDTO used in the response entity when throws a error in the service.
 */
@Getter
@Setter
@ToString
public class ErrorDTO {

    /**
     * The datetime when error happens.
     */
    private LocalDateTime timestamp;
    /**
     * The HTTP status code error.
     */
    private Integer status;
    /**
     * The error message.
     */
    private String error;
    /**
     * Path of the service throw the error.
     */
    private String path;
}
