package com.sistema.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistema.models.model.Encomenda;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {

	@Query(value="SELECT p FROM Encomenda p "
			+ "WHERE p.idEncomenda LIKE(CONCAT('%',:keyword,'%')) "
			+ "OR p.codEncomenda LIKE(CONCAT('%',:keyword,'%')) "
			+ "OR p.nomeEncomenda LIKE(CONCAT('%',:keyword,'%')) "
			+ "OR p.cidade.nomeCidade LIKE(CONCAT('%',:keyword,'%'))")
	List<Encomenda> findAllByFields(@Param("keyword") String keyword);

}
