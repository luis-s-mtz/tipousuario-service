package mx.com.trainee.tipousuario.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luis
 * @since 1.0
 *
 * Configuration class to create a Bean of ModelMapper class.
 */
@Configuration
public class UserTypeModelMappConfiguration {

    /**
     * Method to create the Bean of ModelMapper class.
     * @return ModelMapper object.
     */
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
