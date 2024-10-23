package pe.com.cibertec.Proyecto_biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.cibertec.Proyecto_biblioteca.model.entity.DisponibilidadEntity;


public interface DisponibilidadService {
	List<DisponibilidadEntity>obtenerTodasDisponibilidad();
}
