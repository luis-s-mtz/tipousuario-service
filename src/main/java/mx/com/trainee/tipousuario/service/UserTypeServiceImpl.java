package mx.com.trainee.tipousuario.service;

import lombok.extern.slf4j.Slf4j;
import mx.com.trainee.tipousuario.model.entity.UserType;
import mx.com.trainee.tipousuario.model.repository.UserTypeRepository;
import mx.com.trainee.tipousuario.model.response.UserTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author luis
 * @since 1.0
 *
 * Class to implement methods used in the service layer of API tipousuario-service.
 */
@Slf4j
@Service
public class UserTypeServiceImpl implements IUserTypeService{

    /**
     * Bean of the repository.
     */
    private final UserTypeRepository userTypeRepository;
    /**
     *  Bean of the modelMapper.
     */
    private final ModelMapper modelMapper;
    /**
     * Bean of the circuitBreakerFactory.
     */
    private final CircuitBreakerFactory circuitBreakerFactory;

    /**
     * Constructor of UserTypeServiceImpl class using as parameters the used Beans.
     * @param userTypeRepository Bean of the repository to ejecute DAO to the UserType entity.
     * @param modelMapper Bean of the modelMapper to convert from UserType entity to UserType DTO.
     * @param circuitBreakerFactory Bean of the circuitBreakerFactory to implement CircuitBraker.
     */
    public UserTypeServiceImpl(UserTypeRepository userTypeRepository, ModelMapper modelMapper, CircuitBreakerFactory circuitBreakerFactory) {
        this.userTypeRepository = userTypeRepository;
        this.modelMapper = modelMapper;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    /**
     * Method to return all records of Permiso object.
     *
     * @param id Identifier of TipoUsuario entity.
     * @return A response entity of TipoUsuario object.
     */
    @Override
    public ResponseEntity<UserTypeDTO> getById(Integer id) {

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("cbGetById");

        UserType userType =circuitBreaker.run(
                () -> getResultQuerybyId(id),throwable -> {
                    log.error("Error in [{}] getById: ",this.getClass().getName());
                        throw new RuntimeException("Error when execute findById");});

        return ResponseEntity.ok(modelMapper.map(userType,UserTypeDTO.class));
    }

    private UserType getResultQuerybyId(Integer id) {
        Optional<UserType> optionalUserType = userTypeRepository.findById(id);
        return optionalUserType.orElse(null);
    }
}
