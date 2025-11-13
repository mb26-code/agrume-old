package fr.umontpellier.hai925i.agrume.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import fr.umontpellier.hai925i.agrume.repository.*;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private CampusRepository campusRepository;

    @Autowired
    private BatimentRepository batimentRepository;

    @Override
    public void run(String... args) {
        System.out.println("--- Remplissage de la base de données AGRUME ---");

        System.out.println("...");

        System.out.println("--- Bases de données remplie ---");
    }
}
