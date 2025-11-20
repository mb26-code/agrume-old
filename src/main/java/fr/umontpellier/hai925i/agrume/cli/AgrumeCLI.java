package fr.umontpellier.hai925i.agrume.cli;


import fr.umontpellier.hai925i.agrume.model.Batiment;
import fr.umontpellier.hai925i.agrume.model.Campus;
import fr.umontpellier.hai925i.agrume.model.Composante;
import fr.umontpellier.hai925i.agrume.model.Salle;
import fr.umontpellier.hai925i.agrume.repository.BatimentRepository;
import fr.umontpellier.hai925i.agrume.repository.CampusRepository;
import fr.umontpellier.hai925i.agrume.repository.ComposanteRepository;
import fr.umontpellier.hai925i.agrume.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class AgrumeCLI implements CommandLineRunner {

    @Autowired
    private CampusRepository campusRepository;

    @Autowired
    private BatimentRepository batimentRepository;

    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private ComposanteRepository composanteRepository;


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n=================================");
        System.out.println("          TEST ORM/JPA           ");
        System.out.println("=================================\n");


        System.out.println("\n--- Liste des Campus ---");
        for (Campus campus : campusRepository.findAll()) {
            System.out.println("-> " + campus.toString());

            //test de la relation OneToMany liant Campus à Batiment
            //(on vérifie qu'on arrive à récupérer les bâtiments liés à chaque campus)
            if (!campus.getBatiments().isEmpty()) {
                System.out.println("    | (contient " + campus.getBatiments().size() + " bâtiments)");
                for (Batiment batiment : campus.getBatiments()) {
                    System.out.println("    |-> " + batiment);
                }
            } else {
                System.out.println("      (vide)");
            }
        }


        System.out.println("\n--- Liste des Salles ---");
        for (Salle salle : salleRepository.findAll()) {
            System.out.println("-> " + salle.toString() + " (Bâtiment: " + salle.getBatiment().getId() + ")");
        }


        System.out.println("\n--- Liste des Composantes ---");
        for (Composante composante : composanteRepository.findAll()) {
            System.out.println("-> " + composante.toString());

            if (!composante.getBatiments().isEmpty()) {
                for (Batiment batiment : composante.getBatiments()) {
                    System.out.println("    |-> exploite le bâtiment " + batiment.toString());
                }
            }
        }

        System.out.println("\n=================================");
        System.out.println("           FIN DU TEST          ");
        System.out.println("=================================\n");

    }
}