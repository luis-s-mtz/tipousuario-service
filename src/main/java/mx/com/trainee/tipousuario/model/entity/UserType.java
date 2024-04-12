package mx.com.trainee.tipousuario.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author luis
 * @since 1.0
 *
 * Entity class of the table TipoUsuario.
 */
@Entity
@Table(name = "TipoUsuario")
@Getter
@Setter
@ToString
public class UserType {

    /**
     * Identifier of record.
     */
    @Id
    @Column
    private Integer id;

    /**
     * Description column.
     */
    @Column(name = "descripcion")
    private String description;

    /**
     * Active column.
     */
    @Column(name = "activo")
    private Integer status;
}
