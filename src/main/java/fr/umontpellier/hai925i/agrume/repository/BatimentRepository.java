package fr.umontpellier.hai925i.agrume.repository;


import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.umontpellier.hai925i.agrume.model.*;


@Repository
public interface BatimentRepository extends JpaRepository<Batiment, String> {

    //consultation

    @Query("SELECT * FROM batiment;")
    List<Batiment> getAll();

    @Query("SELECT b FROM batiment b WHERE b.id = :batimentId;")
    Batiment getFromId(@Param("batimentId") String batimentId);

    @Query("SELECT b FROM batiment b WHERE b.id IN :batimentIds;")
    List<Batiment> getFromIds(@Param("batimentIds") List<String> batimentIds);

    @Query("SELECT b FROM batiment b WHERE b.campus = :campusId;")
    List<Batiment> getFromCampus(@Param("campusId") String campusId);

    @Query("SELECT b FROM batiment b WHERE b.campus IN :campusIds;")
    List<Batiment> getFromCampus(@Param("campusIds") List<String> campusIds);

    //création

    default Batiment add(Batiment batiment) {
        Batiment persistedBatiment = this.save(batiment);
        this.flush();
        return persistedBatiment;

    }

    //modification

    @Query("UPDATE batiment SET annee = :annee, campus = :campusId WHERE id = :batimentId;")
    default boolean setAttributes(@Param("batimentId") String batimentId,
                                  @Param("annee") int annee,
                                  @Param("campusId") String campusId) {
        //
        return true;
    }


    //suppression
    @Query("DELETE FROM batiment WHERE id = :batimentId;")
    void remove(@Param("batimentId") String batimentId);

    @Query("DELETE FROM batiment WHERE id IN :batimentIds;")
    void removeFromIds(@Param("batimentIds") List<String> batimentIds);

    @Query("DELETE FROM batiment WHERE campus = :campusId;")
    void removeFromCampus(@Param("campusId") String campusId);

    @Query("DELETE FROM batiment WHERE campus IN :campusIds;")
    void removeFromCampus(@Param("campusIds") List<String> campusIds);

    @Query("DELETE FROM batiment;")
    void removeAll();

}
