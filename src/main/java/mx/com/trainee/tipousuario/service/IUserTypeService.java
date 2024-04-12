package mx.com.trainee.tipousuario.service;

import mx.com.trainee.tipousuario.model.response.UserTypeDTO;
import org.springframework.http.ResponseEntity;

/**
 * @author luis
 * @since 1.0
 *
 * Interface to define the methods used in each entry point of the API tipousuario-service.
 */
public interface IUserTypeService {

    /**
     * Method to return all records of Permiso object.
     * @param id Identifier of TipoUsuario entity.
     * @return A response entity of TipoUsuario object.
     */
    ResponseEntity<UserTypeDTO> getById(Integer id);
}
