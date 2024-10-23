package pe.com.cibertec.Proyecto_biblioteca.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.Proyecto_biblioteca.model.entity.DisponibilidadEntity;
import pe.com.cibertec.Proyecto_biblioteca.repository.DisponibilidadRepository;
import pe.com.cibertec.Proyecto_biblioteca.service.DisponibilidadService;

@Service
@RequiredArgsConstructor
public class DisponibilidadServiceImpl implements DisponibilidadService {

	private final DisponibilidadRepository disponibilidadRepository;
	@Override
	public List<DisponibilidadEntity> obtenerTodasDisponibilidad() {
		// TODO Auto-generated method stub
		return disponibilidadRepository.findAll();
	}

}
