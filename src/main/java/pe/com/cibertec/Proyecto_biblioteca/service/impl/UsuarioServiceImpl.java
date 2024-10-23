package pe.com.cibertec.Proyecto_biblioteca.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.Proyecto_biblioteca.model.entity.UsuarioEntity;
import pe.com.cibertec.Proyecto_biblioteca.repository.UsuarioRepository;
import pe.com.cibertec.Proyecto_biblioteca.service.UsuarioService;
import pe.com.cibertec.Proyecto_biblioteca.utils.Utilitarios;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{
	
	private final UsuarioRepository usuarioRepository;
	
	@Override
	public void crearUsuario(UsuarioEntity usuarioEntity) {
		String passwordHash = Utilitarios.extraerHash(usuarioEntity.getPassword());
		usuarioEntity.setPassword(passwordHash);
		usuarioRepository.save(usuarioEntity);	
	}

	@Override
	public List<UsuarioEntity> buscarUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioEntity buscarUsuarioPorId(String id) {
		return usuarioRepository.findById(id)
				.get();
	}

	@Override
	public boolean validarUsuario(UsuarioEntity usuarioFormulario) {
		// 1. Recuperar el usuario por correo
		UsuarioEntity usuarioEncontrado = usuarioRepository
				.findByEmail(usuarioFormulario.getEmail());
		
		// correo existe?
		if(usuarioEncontrado == null) {
			return false;
		}
		//2. Validar password input con el hash de la base de datos
		if(Utilitarios.checkPassword(usuarioFormulario.getPassword(),
				usuarioEncontrado.getPassword())) {
			return false;
		}
		
		//3. login exitoso	
		return true;

	}

	@Override
	public void eliminarUsuario(String id) {
		UsuarioEntity usuarioEncontrado = buscarUsuarioPorId(id);
		if(usuarioEncontrado == null) {
			throw new RuntimeException("Usuario no encontrado");
		}
		usuarioRepository.delete(usuarioEncontrado);
		
	}
		



	@Override
	public void actualizarUsuario(String id, UsuarioEntity usuarioActualizado) {
		UsuarioEntity usuarioEncontrado = buscarUsuarioPorId(id);
		if(usuarioEncontrado == null) {
			throw new RuntimeException("Usuario no encontrado");
		}
		try {
			usuarioEncontrado.setNombre(usuarioActualizado.getNombre());
			usuarioEncontrado.setApellido(usuarioActualizado.getApellido());
			usuarioEncontrado.setEmail(usuarioActualizado.getEmail());
			usuarioEncontrado.setPassword(usuarioActualizado.getPassword());
			usuarioRepository.save(usuarioEncontrado);
		}catch (Exception e) {
			throw new RuntimeException("Error al actualizar");
		}
			
	}

}
