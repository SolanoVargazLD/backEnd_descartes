package com.descartes_api.repository;

import com.descartes_api.model.AspirantBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AspirantBasicRepository  extends JpaRepository<AspirantBasic, Integer> {
    Optional<AspirantBasic> findByAspirantId(int aspirantId);

    @Query("SELECT ab.id , a.id, a.tipoAspirant ,a.name, a.lastNameP, a.lastNameM, a.curp " +
            "FROM Aspirant a " +
            "INNER JOIN AspirantBasic ab ON a.id=ab.aspirant.id " +
            "INNER JOIN  LevelBasic lb ON ab.levelBasic.id = lb.id " +
            "WHERE lb.name= :nameNivel ")
    List<Object[]> findAspirantsWithBasicNivel(@Param("nameNivel") String nameNivel);

    List<AspirantBasic> findByLevelBasicName(String levelName);
}