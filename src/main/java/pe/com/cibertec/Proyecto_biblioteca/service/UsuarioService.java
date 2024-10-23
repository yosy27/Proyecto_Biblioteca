package pe.com.cibertec.Proyecto_biblioteca.service;


import java.util.List;

import pe.com.cibertec.Proyecto_biblioteca.model.entity.UsuarioEntity;

public interface UsuarioService {
	List<UsuarioEntity>buscarUsuarios();
	void crearUsuario(UsuarioEntity usuarioEntity);
	UsuarioEntity buscarUsuarioPorId(String id);
	void actualizarUsuario(String id, UsuarioEntity usuarioEntity);
	boolean validarUsuario(UsuarioEntity usuarioEntity);
	void eliminarUsuario(String id);
}
