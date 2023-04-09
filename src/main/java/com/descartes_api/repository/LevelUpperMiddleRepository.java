package com.descartes_api.repository;

import com.descartes_api.model.LevelUpperMiddle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelUpperMiddleRepository extends JpaRepository<LevelUpperMiddle, Integer> {
}
