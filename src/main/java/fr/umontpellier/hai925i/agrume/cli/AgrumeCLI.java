package fr.umontpellier.hai925i.agrume.cli;


import fr.umontpellier.hai925i.agrume.model.Batiment;
import fr.umontpellier.hai925i.agrume.model.Campus;
import fr.umontpellier.hai925i.agrume.repository.BatimentRepository;
import fr.umontpellier.hai925i.agrume.repository.CampusRepository;
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


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n=================================");
        System.out.println("          TEST ORM/JPA           ");
        System.out.println("=================================\n");


        System.out.println("--- Liste des Campus ---");
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


        System.out.println("\n=================================");
        System.out.println("           FIN DU TEST          ");
        System.out.println("=================================\n");
    }
}