package pe.com.cibertec.Proyecto_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.Proyecto_biblioteca.model.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String>{
	UsuarioEntity findByCorreo(String correo);
}
