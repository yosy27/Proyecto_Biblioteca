package pe.com.cibertec.Proyecto_biblioteca.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import pe.com.cibertec.Proyecto_biblioteca.model.entity.LibroEntity;
import pe.com.cibertec.Proyecto_biblioteca.repository.LibroRepository;
import pe.com.cibertec.Proyecto_biblioteca.service.LibroService;
import pe.com.cibertec.Proyecto_biblioteca.utils.Utilitarios;

@Service
@AllArgsConstructor
public class LibroServiceImpl implements LibroService{

	private final LibroRepository libroRepository;

	@Override
	public List<LibroEntity> listarLibros() {
		return libroRepository.findAll();
	}
	
	@Override
	public void crearLibro(LibroEntity libroEntity, MultipartFile foto) {
		String nombreFoto = Utilitarios.guardarImagen(foto);
		libroEntity.setUrLImagenLibro(nombreFoto);
		libroRepository.save(libroEntity);
	}

	@Override
	public LibroEntity buscarLibroPorId(Integer id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id).get();
	}

	@Override
	public void actualizarLibro(Integer id, LibroEntity libroActualizado) {
		// TODO Auto-generated method stub
		LibroEntity libroEncontrado = buscarLibroPorId(id);
		if(libroEncontrado == null) {
			throw new RuntimeException("Libro no encontrado");
		}
		try {
			libroEncontrado.setTitulo(libroActualizado.getTitulo());
			libroEncontrado.setAutor(libroActualizado.getAutor());
			libroEncontrado.setISBN(libroActualizado.getISBN());
			libroEncontrado.setDisponible(libroActualizado.getDisponible());
			libroEncontrado.setCategoriaEntity(libroActualizado.getCategoriaEntity());
			libroEncontrado.setUrLImagenLibro(libroActualizado.getUrLImagenLibro());
			libroRepository.save(libroEncontrado);
		}catch(Exception e) {
			throw new RuntimeException("Error al actualizar");
		}
		
	}

	@Override
	public void eliminarLibro(Integer id) {
		// TODO Auto-generated method stub
		LibroEntity libroEncontrado = buscarLibroPorId(id);
		if(libroEncontrado == null) {
			throw new RuntimeException("Libro no encontrado");
		}
		libroRepository.delete(libroEncontrado);
		
	}


}
