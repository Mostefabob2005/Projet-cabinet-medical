import java.time.LocalDateTime;

public class Secretaire extends Personne {

    public Secretaire(String nom, String prenom, String telephone) {
        super(nom, prenom, telephone);
    }

    public RendezVous prendreRendezVous(Patient patient, Medecin medecin, LocalDateTime dateHeure) {
        if (medecin.estDisponible(dateHeure)) {
            RendezVous rdv = new RendezVous(patient, medecin, dateHeure);
            medecin.ajouterRendezVous(rdv);
            System.out.println("Rendez-vous pris avec succès pour le " + dateHeure);
            return rdv;
        } else {
            System.out.println("Le médecin n'est pas disponible à cette date.");
            return null;
        }
    }

    @Override
    public void afficherDetails() {
        System.out.println("Secrétaire - " + super.getNom() + " " + super.getPrenom());
    }
}
