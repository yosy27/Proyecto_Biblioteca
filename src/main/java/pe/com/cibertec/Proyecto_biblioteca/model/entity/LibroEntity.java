package pe.com.cibertec.Proyecto_biblioteca.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_libro")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LibroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer idLibro;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="ISBN")
	private Integer ISBN;
	
	@Column(name = "url_imagen")
	private String urLImagenLibro;
	
	@Column(name="disponible")
	private Boolean disponible;
	
	@ManyToOne
	@JoinColumn(name="fk_categoria", nullable = false)
	private CategoriaEntity categoriaEntity;

}
