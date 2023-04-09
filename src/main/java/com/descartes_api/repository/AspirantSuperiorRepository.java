package com.descartes_api.repository;

import com.descartes_api.model.AspirantSuperior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspirantSuperiorRepository extends JpaRepository<AspirantSuperior, Integer> {
}