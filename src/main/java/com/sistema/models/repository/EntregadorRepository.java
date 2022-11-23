package com.sistema.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistema.models.model.Entregador;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

	@Query(value="SELECT p FROM Entregador p "
			+ "WHERE p.idEntregador LIKE(CONCAT('%',:keyword,'%')) "
			+ "OR p.codEntregador LIKE(CONCAT('%',:keyword,'%')) "
			+ "OR p.nomeEntregador LIKE(CONCAT('%',:keyword,'%')) "
			+ "OR p.cidade.nomeCidade LIKE(CONCAT('%',:keyword,'%'))")
	List<Entregador> findAllByFields(@Param("keyword") String keyword);

}
