package fr.umontpellier.hai925i.agrume.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.umontpellier.hai925i.agrume.model.*;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment, String> {
    // JPQL Query
    @Query("SELECT b FROM Batiment b WHERE b.codeB IN :ids")
    List<Batiment> findByIds(@Param("ids") List<String> ids);

    List<Batiment> findByCampus(Campus campus);
}
