

public class Personne implements ActionPersonne {
    private String nom;
    private String prenom;
    private String telephone;

    public Personne(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Nom: " + nom + ", Prénom: " + prenom + ", Téléphone: " + telephone);
    }
}
