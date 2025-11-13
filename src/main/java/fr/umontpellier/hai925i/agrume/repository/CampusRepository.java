package fr.umontpellier.hai925i.agrume.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.umontpellier.hai925i.agrume.model.*;

@Repository
public interface CampusRepository extends JpaRepository<Campus, String> {

    List<Campus> findByVille(String ville);

}
