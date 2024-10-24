package pe.com.cibertec.Proyecto_biblioteca.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_categoria")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria", nullable=false)
	private Integer idCategoria;
	
	@Column(name="nombre_categoria",nullable = false)
	private String nombreCategoria;
}
