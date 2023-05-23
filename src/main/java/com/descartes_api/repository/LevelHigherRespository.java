package com.descartes_api.repository;

import com.descartes_api.model.LevelHigher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelHigherRespository extends JpaRepository<LevelHigher, Integer> {
    @Query("SELECT lh.id, lh.nameCareer FROM LevelHigher lh WHERE lh.nivelEducativo = 'licenciatura'")
    List<Object[]> findIdAndNivelEducativoByLicenciatura();

    @Query("SELECT lh.id, lh.nameCareer FROM LevelHigher lh WHERE lh.nivelEducativo = :nivelEducativePosgrado")
    List<Object[]> findIdAndNivelEducativoByPosgrado(@Param("nivelEducativePosgrado") String nivelEducativePosgrado);

}
