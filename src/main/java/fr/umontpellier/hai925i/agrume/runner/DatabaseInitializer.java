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
        System.out.println("\n============================================");
        System.out.println("   Remplissage de la base de données AGRUME ");
        System.out.println("============================================\n");

        System.out.println("DatabaseInitializer non-implémenté pour l'instant.");
        System.out.println("(données ajoutées manuellement via le terminal)");

        System.out.println("\n========================================");
        System.out.println("        Base de données remplie ");
        System.out.println("========================================\n");
    }
}
