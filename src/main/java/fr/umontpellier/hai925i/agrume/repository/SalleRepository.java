package fr.umontpellier.hai925i.agrume.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.umontpellier.hai925i.agrume.model.*;


@Repository
public interface SalleRepository extends JpaRepository<Salle, String> {

    List<Salle> findByBatiment(Batiment batiment);

    List<Salle> findByType(String type);

}