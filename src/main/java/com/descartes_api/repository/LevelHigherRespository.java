package com.descartes_api.repository;

import com.descartes_api.model.LevelHigher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelHigherRespository extends JpaRepository<LevelHigher, Integer> {
}
