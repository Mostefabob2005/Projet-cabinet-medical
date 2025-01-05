

public class Patient extends Personne {
    private DossierMedical dossierMedical;
    private String adresse;

    public Patient(String nom, String prenom, String telephone, String adresse) {
        super(nom, prenom, telephone);
        this.dossierMedical = new DossierMedical();
        this.adresse=adresse;
        
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }
    public String getadresse() {
        return adresse;
    }
    public void setadresse(String adresse){
        this.adresse=adresse;
    }
   

    @Override
    public void afficherDetails() {
        System.out.println("Patient - " + super.getNom() + " " + super.getPrenom());
        System.out.println(dossierMedical);
    }
}
