import java.util.ArrayList;

public class PatientManager {
    private ArrayList<Patient> patients;

    public PatientManager() {
        this.patients=new ArrayList<>();
    }
    public void addpatient(Patient p) {
        patients.add(p);
    }
    public void affichepatient() {
        for (Patient p:patients) {
            System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.getTelephone()+"----");
        }
    }
    public void supprimepatient(Patient p) {
        patients.remove(p);
    }
    public boolean estvide() {
        if(patients.isEmpty()==true) {
            return true;
        } else {
            return false;
        }
    }
}

