package com.descartes_api.repository;

import com.descartes_api.model.AspirantBachillerate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AspirantBachillerateRepository extends JpaRepository<AspirantBachillerate, Integer> {
    Optional<AspirantBachillerate> findByAspirantId(int aspirantId);

    @Query("SELECT ab.id , a.id, a.tipoAspirant ,a.name, a.lastNameP, a.lastNameM, a.curp FROM AspirantBachillerate ab JOIN ab.aspirant a")
    List<Object[]> findAspirantsWithBachillerateInfo();
}