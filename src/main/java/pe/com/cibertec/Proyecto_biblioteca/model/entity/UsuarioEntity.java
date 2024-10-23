package pe.com.cibertec.Proyecto_biblioteca.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_usuario", uniqueConstraints = @UniqueConstraint(columnNames = "dniUsuario"))
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

	@Id
	@Column(name = "dniUsuario", nullable = false, columnDefinition = "CHAR(8)",length = 8 )
	private String dni;
	
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 60, nullable = false)
	private String apellido;
	
	@Column(name = "email", nullable = false, length =60)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
}
