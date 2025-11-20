package fr.umontpellier.hai925i.agrume.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.umontpellier.hai925i.agrume.model.*;


@Repository
public interface SalleRepository extends JpaRepository<Salle, String> {

    @Query("SELECT s FROM Salle s WHERE s.batiment = :batiment")
    List<Salle> findByBatiment(@Param("batiment") Batiment batiment);

    @Query("SELECT s FROM Salle s WHERE s.type = :type")
    List<Salle> findByType(@Param("type") TypeSalle type);

}