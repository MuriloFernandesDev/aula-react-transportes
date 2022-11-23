package com.sistema.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistema.models.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	@Query(value="SELECT p FROM Cidade p "
			+ "WHERE p.idCidade LIKE(CONCAT('%',:keyword,'%')) "
			+ "OR p.codCidade LIKE(CONCAT('%',:keyword,'%')) "
			+ "OR p.nomeCidade LIKE(CONCAT('%',:keyword,'%')) ")
	List<Cidade> findAllByFields(@Param("keyword") String keyword);
	
}
