package com.descartes_api.repository;

import com.descartes_api.model.AspirantSuperior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AspirantSuperiorRepository extends JpaRepository<AspirantSuperior, Integer> {
    Optional<AspirantSuperior> findByAspirantId(int aspirantId);

}