package com.descartes_api.repository;

import com.descartes_api.model.AspirantBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AspirantBasicRepository  extends JpaRepository<AspirantBasic, Integer> {
    Optional<AspirantBasic> findByAspirantId(int aspirantId);

//    @Query("SELECT ae.id, ae.name, ae.lastNameP, ae.lastNameM, ae.curp " +
  //          "FROM Aspirant ae " +
    //        "JOIN AspirantBasic ab ON ae.id = ab.levelBasic")
    @Query("SELECT a.id, a.name, a.lastNameP, a.lastNameM, a.curp FROM AspirantBasic ab JOIN ab.aspirant a")
    List<Object[]> findAspirantsWithBasicInfo();


}