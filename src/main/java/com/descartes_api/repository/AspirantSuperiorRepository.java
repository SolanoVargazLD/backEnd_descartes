package com.descartes_api.repository;

import com.descartes_api.model.AspirantSuperior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AspirantSuperiorRepository extends JpaRepository<AspirantSuperior, Integer> {
    Optional<AspirantSuperior> findByAspirantId(int aspirantId);

    @Query("SELECT s.id, a.id, a.tipoAspirant, a.name, a.lastNameP, a.lastNameM, a.curp FROM Aspirant a JOIN a.aspirantSuperior s JOIN s.levelHigher lh WHERE lh.nivelEducativo = 'Licenciatura' AND lh.nameCareer = :nameCareer")
    List<Object[]> findAspirantsByLevelHigherNameCareer(@Param("nameCareer") String nameCareer);

    @Query("SELECT ab.id , a.id, a.tipoAspirant ,a.name, a.lastNameP, a.lastNameM, a.curp FROM AspirantSuperior ab JOIN ab.aspirant a")
    List<Object[]> findAspirantsSuperiorInfo();

}