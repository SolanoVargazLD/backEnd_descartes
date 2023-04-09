package com.descartes_api.repository;

import com.descartes_api.model.AspirantBachillerate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspirantBachillerateRepository extends JpaRepository<AspirantBachillerate, Integer> {
}