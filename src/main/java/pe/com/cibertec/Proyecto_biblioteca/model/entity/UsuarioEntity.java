package pe.com.cibertec.Proyecto_biblioteca.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_usuario")
@Setter
@Getter
public class UsuarioEntity {

	@Id
	@GeneratedValue()
	private Integer idUsuario;
}
