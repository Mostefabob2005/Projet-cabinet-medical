import java.time.LocalDateTime;

public class RendezVous {
    private Patient patient;
    private Medecin medecin;
    private LocalDateTime dateHeure;

    public RendezVous(Patient patient, Medecin medecin, LocalDateTime dateHeure) {
        this.patient = patient;
        this.medecin = medecin;
        this.dateHeure = dateHeure;
    }

    // Getters
    public Patient getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    // Setters
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }
    public boolean coincide(RendezVous rdv1 , RendezVous rdv2) {
        if(rdv1.dateHeure==rdv2.dateHeure){
            return true;
        } else {
            return false;
        }
        
    }

    @Override
    public String toString() {
        return "Rendez-vous avec le Dr " + medecin.getNom() + " pour " + patient.getNom() + " à " + dateHeure;
    }
}
