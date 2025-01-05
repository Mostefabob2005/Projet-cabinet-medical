import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CabinetMedicale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedecinManager medecinManager = new MedecinManager();
        PatientManager patientManager = new PatientManager();

        System.out.println("------------------------------------------------");
        System.out.println("Bienvenue au cabinet médical !");
        System.out.println("------------------------------------------------");

        try {
            // Ajouter un médecin
            System.out.println("Ajoutons un médecin au cabinet.");
            System.out.print("Nom du médecin : ");
            String nomMedecin = scanner.nextLine();
            System.out.print("Prénom du médecin : ");
            String prenomMedecin = scanner.nextLine();
            System.out.print("Téléphone du médecin : ");
            String telephoneMedecin = scanner.nextLine();
            System.out.print("Spécialité du médecin : ");
            String specialiteMedecin = scanner.nextLine();

            Medecin medecin = new Medecin(nomMedecin, prenomMedecin, telephoneMedecin, specialiteMedecin);
            medecinManager.addMedecins(medecin);
            System.out.println("Médecin ajouté avec succès !");
            System.out.println("------------------------------------------------");

            // Ajouter un patient
            System.out.println("Ajoutons un patient au cabinet.");
            System.out.print("Nom du patient : ");
            String nomPatient = scanner.nextLine();
            System.out.print("Prénom du patient : ");
            String prenomPatient = scanner.nextLine();
            System.out.print("Téléphone du patient : ");
            String telephonePatient = scanner.nextLine();

            String adressePatient;
            do {
                System.out.print("Adresse email (doit inclure '@' et '.') : ");
                adressePatient = scanner.nextLine();
            } while (!adressePatient.contains("@") || !adressePatient.contains("."));


            Patient patient = new Patient(nomPatient, prenomPatient, telephonePatient, adressePatient);
            patientManager.addpatient(patient);
            System.out.println("Patient ajouté avec succès !");
            System.out.println("------------------------------------------------");

            // debut du rendez-vous
            System.out.println("Prenons un rendez-vous pour le patient avec le médecin.");
            System.out.println("Médecin disponible : " + medecin.getNom() + " " + medecin.getPrenom());
            System.out.print("Entrez la date et l'heure du rendez-vous (format: yyyy-MM-dd HH:mm) : ");
            String input = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dateHeure = LocalDateTime.parse(input, formatter);
                Secretaire secretaire = new Secretaire("AitAli", "Amine", "0987 65 43 21");

                secretaire.prendreRendezVous(patient, medecin, dateHeure);
                System.out.println("Rendez-vous pris avec succès !");

                // Consultation
                System.out.println("\n--- Début de la consultation ---");
                double poids;
                do {
                System.out.print("Poids du patient (en kg) : ");
                while (!scanner.hasNextDouble()) {
                System.out.println("Veuillez entrer un poids valide.");
                scanner.next(); 
                }
                poids = scanner.nextDouble();
                if (poids < 0 || poids > 300) {
                System.out.println("Le poids doit être compris entre 1 et 300 kg. Veuillez réessayer.");
                }
                } while (poids < 0 || poids > 300);

                double taille;
                do {
                System.out.print("Taille du patient (en m) : ");
                while (!scanner.hasNextDouble()) {
                System.out.println("Veuillez entrer une taille valide.");
                scanner.next(); 
                }
                taille = scanner.nextDouble();
                if (taille < 0 || taille > 2.5) {
                System.out.println("La taille doit être comprise entre 0 et 2.5 m. Veuillez réessayer.");
                }
                } while (taille < 0 || taille > 2.5);
                scanner.nextLine(); // Consomme le saut de ligne
                System.out.print("Allergies du patient : ");
                String allergies = scanner.nextLine();
                System.out.print("Traitements en cours : ");
                String traitements = scanner.nextLine();

                // Mettre à jour le dossier médical
                patient.getDossierMedical().setPoids(poids);
                patient.getDossierMedical().setTaille(taille);
                patient.getDossierMedical().setAllergies(allergies);
                patient.getDossierMedical().setTraitements(traitements);

                medecin.consulter(patient);

                // Rédiger une ordonnance
                System.out.print("Ordonnance (médicaments, doses, durée) : ");
                String ordonnance = scanner.nextLine();
                medecin.ecrireOrdonnance(patient, ordonnance);

                // Afficher les détails
                System.out.println("\n--- Détails du médecin ---");
                medecin.afficherDetails();

                System.out.println("\n--- Détails du patient ---");
                patient.afficherDetails();

            } catch (DateTimeParseException e) {
                System.out.println("Format de date invalide ! Utilisez le format : yyyy-MM-dd HH:mm.");
            }
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
