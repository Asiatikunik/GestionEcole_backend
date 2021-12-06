package archi.archi_phase2.Service;

import archi.archi_phase2.Modele.UniteEnseignement;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Service
public class UniteEnseignementService {

    public List<UniteEnseignement> getUEs() {
        ObjectMapper mapper = new ObjectMapper();
        String file = "src/main/resources/json/ue.json";
        List<UniteEnseignement> ue = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ue = Arrays.asList(mapper.readValue(reader,UniteEnseignement[].class));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return ue;
    }

    public UniteEnseignement getUEByName(String sigle) throws IOException {
        List<UniteEnseignement> listUE = getUEs();
        for(UniteEnseignement ue: listUE) {
            if(ue.getSigle().equals(sigle)) {
                return ue;
            }
        }
        return null;
    }

    public void addUe(UniteEnseignement uniteEnseignement) throws IOException {
//        uniteEnseignement.setNom("duy");
//        uniteEnseignement.setSigle("duy");

        String file = "src/main/java/json/ue.json";
        ObjectMapper objectMapper = new ObjectMapper();
        List<UniteEnseignement> listUE = this.getUEs();
        listUE.add(uniteEnseignement);
        UniteEnseignement ue = new UniteEnseignement(uniteEnseignement.getSigle(), uniteEnseignement.getNom());
        objectMapper.writeValue(new File(file), listUE);
    }
}
