package fr.umontpellier.hai925i.agrume.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.umontpellier.hai925i.agrume.model.*;


@Repository
public interface CampusRepository extends JpaRepository<Campus, String> {

    @Query("SELECT c FROM Campus c WHERE c.ville = :ville")
    List<Campus> findByVille(@Param("ville") String ville);

}
