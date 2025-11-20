package fr.umontpellier.hai925i.agrume.repository;


import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.umontpellier.hai925i.agrume.model.*;


@Repository
public interface BatimentRepository extends JpaRepository<Batiment, String> {

    @Query("SELECT b FROM Batiment b WHERE b.id IN :ids")
    List<Batiment> findByIds(@Param("ids") List<String> ids);

    @Query("SELECT b FROM Batiment b WHERE b.campus = :campus")
    List<Batiment> findByCampus(@Param("campus") Campus campus);
}
