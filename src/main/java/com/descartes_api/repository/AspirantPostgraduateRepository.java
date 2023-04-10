package com.descartes_api.repository;

import com.descartes_api.model.AspirantPostgraduate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AspirantPostgraduateRepository extends JpaRepository<AspirantPostgraduate, Integer> {
    Optional<AspirantPostgraduate> findByAspirantId(int aspirantId);

}