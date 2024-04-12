package mx.com.trainee.tipousuario.model.repository;

import mx.com.trainee.tipousuario.model.entity.UserType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author luis
 * @since 1.0
 *
 * Repository of the UserType entity.
 */
public interface UserTypeRepository extends CrudRepository<UserType,Integer> {
}
