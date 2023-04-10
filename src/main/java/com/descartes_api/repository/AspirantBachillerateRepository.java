package com.descartes_api.repository;

import com.descartes_api.model.AspirantBachillerate;
import com.descartes_api.model.AspirantBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AspirantBachillerateRepository extends JpaRepository<AspirantBachillerate, Integer> {
    Optional<AspirantBachillerate> findByAspirantId(int aspirantId);
}