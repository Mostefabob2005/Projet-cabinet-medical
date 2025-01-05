import java.util.ArrayList;


public class MedecinManager {
    
    private ArrayList<Medecin> Medecins;
    public MedecinManager() {
        this.Medecins=new ArrayList<>();
    }
    public void addMedecins(Medecin med) {
        Medecins.add(med);
    }
    public void supprimeMedecins(Medecin med) {
        Medecins.remove(med);
    }
    public boolean estvide() {
        if (Medecins.isEmpty()==true) {
            return true;
        } else {
            return false;
        }
    }
    public void affichemedecins() {
        for(Medecin m:Medecins) {
            System.out.println("-"+m.getNom()+" "+m.getPrenom()+" "+m.getTelephone()+" "+m.getSpecialite());
        }
    }
    public Medecin Choisirmedecin(int i) {
      return Medecins.get(i);

    }

}
