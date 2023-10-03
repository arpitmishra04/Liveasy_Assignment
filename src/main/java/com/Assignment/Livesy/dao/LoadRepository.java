package com.Assignment.Livesy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Assignment.Livesy.entities.Load;

import java.util.List;
import java.util.UUID;
public interface LoadRepository extends JpaRepository<Load, UUID>  {
	@Query("SELECT l FROM Load l WHERE l.shipperId = :shipperId")
    List<Load> findByShipperId(@Param("shipperId")String shipperId);
	@Query("SELECT l FROM Load l WHERE l.Id = :loadId")
	Load getById(@Param("loadId")UUID loadId);
}
