package fr.umontpellier.hai925i.agrume.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.umontpellier.hai925i.agrume.model.*;


@Repository
public interface ComposanteRepository extends JpaRepository<Composante, String> {

    @Query("SELECT c FROM Composante c WHERE c.responsable = :responsable")
    List<Composante> findByResponsable(@Param("responsable") String responsable);

}