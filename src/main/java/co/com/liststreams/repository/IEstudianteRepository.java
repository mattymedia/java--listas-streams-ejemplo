package co.com.liststreams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.liststreams.entity.Estudiante;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
