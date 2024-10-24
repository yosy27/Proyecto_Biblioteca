package pe.com.cibertec.Proyecto_biblioteca.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.Proyecto_biblioteca.model.entity.CategoriaEntity;
import pe.com.cibertec.Proyecto_biblioteca.repository.CategoriaRepository;
import pe.com.cibertec.Proyecto_biblioteca.service.CategoriaService;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

	private final CategoriaRepository categoriaRepository;
	
	@Override
	public List<CategoriaEntity> obtenerTodasCategorias() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

}
