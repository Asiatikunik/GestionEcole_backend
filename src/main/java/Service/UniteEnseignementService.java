package Service;

import Modele.UniteEnseignement;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UniteEnseignementService {

    public List<UniteEnseignement> getUEs() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String file = "src/main/java/json/ue.json";
        List<UniteEnseignement> ue = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ue = Arrays.asList(mapper.readValue(reader,UniteEnseignement[].class));
        }
        catch (IOException e) {
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
}
