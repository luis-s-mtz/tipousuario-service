package mx.com.trainee.tipousuario.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mx.com.trainee.tipousuario.model.response.UserTypeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author luis
 * @since 1.0
 *
 * Interface to define methods used in the Controller of API tipousuario-service.
 */
@RequestMapping("/api/tipousuario")
public interface IUserTypeApiDoc {

    /**
     * Method used as entry point of the GET function that return a record of UserType catalog.
     * @return A ResponseEntity of UserType object.
     */
    @Operation(
            summary = "show",
            description = "Consulta registro por Id de la tabla TipoUsuario."
    )
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = UserTypeDTO.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})
    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    @GetMapping("/{id}")
    ResponseEntity<UserTypeDTO> getById(@PathVariable("id") Integer id);
}
