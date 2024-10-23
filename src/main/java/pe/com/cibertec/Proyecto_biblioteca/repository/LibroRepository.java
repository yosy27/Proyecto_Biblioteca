package pe.com.cibertec.Proyecto_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.Proyecto_biblioteca.model.entity.LibroEntity;
@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Integer>{

}
