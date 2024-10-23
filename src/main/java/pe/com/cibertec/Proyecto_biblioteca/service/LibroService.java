package pe.com.cibertec.Proyecto_biblioteca.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.Proyecto_biblioteca.model.entity.LibroEntity;

public interface LibroService {
	List<LibroEntity>listarLibros();
	void crearLibro(LibroEntity libroEntity, MultipartFile foto);
	LibroEntity buscarLibroPorId(Integer id);
	void actualizarLibro(Integer id, LibroEntity libroEntity);
	void eliminarLibro(Integer id);
}
