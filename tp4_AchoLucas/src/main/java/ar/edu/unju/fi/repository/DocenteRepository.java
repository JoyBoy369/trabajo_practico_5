package ar.edu.unju.fi.repository;

import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Docente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository 
public interface DocenteRepository extends JpaRepository<Docente, Long> {
	List<Docente> findByEstado(boolean estado);
}