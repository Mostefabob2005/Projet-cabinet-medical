

import java.util.ArrayList;
import java.util.List;

public class DossierMedical {
    private List<String> consultations;
    private String allergies;
    private String traitements;
    private double poids;
    private double taille;

    public DossierMedical() {
        consultations = new ArrayList<>();
    }

    // Getters
    public List<String> getConsultations() {
        return consultations;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getTraitements() {
        return traitements;
    }

    public double getPoids() {
        return poids;
    }

    public double getTaille() {
        return taille;
    }

    // Setters
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setTraitements(String traitements) {
        this.traitements = traitements;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public void ajouterConsultation(String consultation) {
        consultations.add(consultation);
    }

    @Override
    public String toString() {
        return "Dossier Médical:\n" +
                "Allergies: " + allergies + "\n" +
                "Traitements: " + traitements + "\n" +
                "Poids: " + poids + " kg, Taille: " + taille + " m\n" +
                "Consultations: " + consultations;
    }
}
