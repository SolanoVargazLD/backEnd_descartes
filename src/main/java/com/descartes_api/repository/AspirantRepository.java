package com.descartes_api.repository;

import com.descartes_api.model.Aspirant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspirantRepository extends JpaRepository<Aspirant, Integer> {
}
