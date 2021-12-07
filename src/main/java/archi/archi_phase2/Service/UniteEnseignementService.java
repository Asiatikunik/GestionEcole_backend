package archi.archi_phase2.Service;

import archi.archi_phase2.Modele.Promotion;
import archi.archi_phase2.Modele.UniteEnseignement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UniteEnseignementService {
    private String filename = "src/main/resources/json/ue.json";

    public List<UniteEnseignement> getUEs() {
        ObjectMapper mapper = new ObjectMapper();
        String file = "src/main/resources/json/ue.json";
        List<UniteEnseignement> ue = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ue = new ArrayList<>(Arrays.asList(mapper.readValue(reader,UniteEnseignement[].class)));
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

    public void addUe(UniteEnseignement ue) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<UniteEnseignement> proms = getUEs();
        proms.add(ue);
        String json = mapper.writeValueAsString(proms);

        FileWriter fw = new FileWriter(new File(filename));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();
    }


}
