package com.descartes_api.repository;

import com.descartes_api.model.AspirantPostgraduate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AspirantPostgraduateRepository extends JpaRepository<AspirantPostgraduate, Integer> {
    Optional<AspirantPostgraduate> findByAspirantId(int aspirantId);

    @Query("SELECT s.id, a.id, a.tipoAspirant, a.name, a.lastNameP, a.lastNameP, s.professionalLicense FROM Aspirant a JOIN a.aspirantPostgraduate s JOIN s.levelHigher lh WHERE lh.nivelEducativo = :nivelEducativo AND lh.nameCareer = :nameCareer")
    List<Object[]> findAspirantsByLevelHigherNameCareerPosgraduate(@Param("nameCareer") String nameCareer, @Param("nivelEducativo") String nivelEducativo);

}