package fr.umontpellier.hai925i.agrume.service;


import fr.umontpellier.hai925i.agrume.model.Campus;
import fr.umontpellier.hai925i.agrume.repository.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CampusService {

    @Autowired
    private CampusRepository campusRepository;


    public List<Campus> getAllCampus() {
        return campusRepository.findAll();
    }

    public void saveCampus(Campus campus) {
        campusRepository.save(campus);
    }

    public void deleteCampus(String nom) {
        campusRepository.deleteById(nom);
    }

    public Campus getCampus(String nom) {
        return campusRepository.findById(nom).orElse(null);
    }
}