package fr.umontpellier.hai925i.agrume.service;

import fr.umontpellier.hai925i.agrume.model.Batiment;
import fr.umontpellier.hai925i.agrume.model.Campus;
import fr.umontpellier.hai925i.agrume.repository.BatimentRepository;
import fr.umontpellier.hai925i.agrume.repository.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatimentService {

    @Autowired
    private BatimentRepository batimentRepository;

    @Autowired
    private CampusRepository campusRepository;

    //consultation

    public List<Batiment> getAll() { return batimentRepository.getAll(); }

    public Batiment getFromId(String batimentId)  { return batimentRepository.getFromId(batimentId); }

    public List<Batiment> getFromIds(List<String> batimentIds) { return batimentRepository.getFromIds(batimentIds); }

    public List<Batiment> getFromCampus(String campusId) { return batimentRepository.getFromCampus(campusId); }

    public List<Batiment> getFromCampus(List<String> campusIds) { return batimentRepository.getFromCampus(campusIds); }


    public int howManyRooms(String batimentId) {
        return 0;
    }

    //


    //création

    Batiment add(Batiment batiment) { return batimentRepository.add(batiment); }


    Batiment create(String batimentId, int annee, String campusId) {

        Campus campus = campusRepository.getFromId(campusId);

        if (campus == null) {
            campus = campusRepository.create(campusId);
        }
        Batiment batiment = new Batiment(batimentId, annee, campusId);

        return batimentRepository.add(batiment);

    }

    //modification

    boolean setAttributes(@Param("batimentId") String batimentId,
                          @Param("annee") int annee,
                          @Param("campusId") String campusId) {
        return batimentRepository.setAttributes(batimentId, annee, campusId);
    }


    //suppression

    public void deleteBatiment(String nom) {}



    //stats

    public int howManyRooms(String batimentId) {}

    public int howManyRooms(Batiment batiment) {}

    public int howManyRooms() {}
}