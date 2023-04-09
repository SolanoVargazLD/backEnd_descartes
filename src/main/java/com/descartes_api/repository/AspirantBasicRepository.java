package com.descartes_api.repository;

import com.descartes_api.model.AspirantBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspirantBasicRepository  extends JpaRepository<AspirantBasic, Integer> {
}