package mx.com.trainee.tipousuario.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import mx.com.trainee.tipousuario.model.response.UserTypeDTO;
import mx.com.trainee.tipousuario.service.IUserTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luis
 * @since 1.0
 *
 * Controller class used to implements endpoints of API tipousuario-service.
 */
@Slf4j
@Tag(name = "TipoUsuario", description = "")
@RestController()
public class UserTypeController implements IUserTypeApiDoc {

    /**
     * Object to implement the business logic of entry point GET byId of the Controller.
     */
    private final IUserTypeService userTypeService;

    /**
     * Constructor of the Controller class.
     * @param userTypeService The Service layer object.
     */
    public UserTypeController(IUserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    /**
     * Method used as entry point of the GET function that return a record of UserType catalog.
     * @return A ResponseEntity of UserType object.
     */
    @Override
    public ResponseEntity<UserTypeDTO> getById(Integer id) {
        log.info("Entry point getByID in UserTypeController id: {}",id);
        return userTypeService.getById(id);
    }
}
