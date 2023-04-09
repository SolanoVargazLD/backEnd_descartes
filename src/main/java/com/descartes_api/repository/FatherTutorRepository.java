package com.descartes_api.repository;

import com.descartes_api.model.FatherTutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatherTutorRepository extends JpaRepository<FatherTutor, Integer> {
}
