
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Medecin extends Personne {
    private String specialite;
    private List<RendezVous> rendezVousList;

    public Medecin(String nom, String prenom, String telephone, String specialite) {
        super(nom, prenom, telephone);
        this.specialite = specialite;
        this.rendezVousList = new ArrayList<>();
    }

    // Getters
    public String getSpecialite() {
        return specialite;
    }

    public List<RendezVous> getRendezVousList() {
        return rendezVousList;
    }

    // Setters
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setRendezVousList(List<RendezVous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }

    public void consulter(Patient patient) {
        System.out.println("Consultation avec le patient " + patient.getNom() + " " + patient.getPrenom());
        patient.getDossierMedical().ajouterConsultation("Consultation avec le Dr " + getNom());
    }

    public void ecrireOrdonnance(Patient patient, String prescription) {
        System.out.println("Ordonnance pour le patient " + patient.getNom() + ": " + prescription);
    }

    public boolean estDisponible(LocalDateTime dateHeure) {
        for (RendezVous rdv : rendezVousList) {
            if (rdv.getDateHeure().equals(dateHeure)) {
                return false;
            }
        }
        return true;
    }

    public void ajouterRendezVous(RendezVous rdv) {
        rendezVousList.add(rdv);
    }
    public void annulerrdv(RendezVous rdv) {
        rendezVousList.remove(rdv);
    }

    @Override
    public void afficherDetails() {
        System.out.println("Médecin - Dr " + super.getNom() + ", Spécialité: " + specialite);
    }
}
