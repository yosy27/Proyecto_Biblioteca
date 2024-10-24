package pe.com.cibertec.Proyecto_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.cibertec.Proyecto_biblioteca.model.entity.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

}
