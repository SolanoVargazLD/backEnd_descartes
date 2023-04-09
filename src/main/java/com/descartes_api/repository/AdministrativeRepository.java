package com.descartes_api.repository;

import com.descartes_api.model.Administrative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativeRepository extends JpaRepository<Administrative, Integer> {
}
