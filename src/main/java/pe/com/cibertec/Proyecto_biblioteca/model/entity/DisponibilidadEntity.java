package pe.com.cibertec.Proyecto_biblioteca.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_disponibilidad")
@Getter
@Setter
public class DisponibilidadEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "disponibilidad_id",nullable = false)
	private Integer idDisponibilidad;
	
	@Column(name = "nombre_disponibilidad")
	private String nombreDisponibilidad;
}
