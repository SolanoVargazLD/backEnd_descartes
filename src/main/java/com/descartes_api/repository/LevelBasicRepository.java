package com.descartes_api.repository;

import com.descartes_api.model.LevelBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelBasicRepository extends JpaRepository<LevelBasic, Integer> {
}
