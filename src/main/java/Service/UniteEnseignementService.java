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
        //List<UniteEnseignement> ues = new ArrayList<>();
        //ues.add(new UniteEnseignement("sigle","nom"));
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/json/ue.json"));

        List<UniteEnseignement> ue = Arrays.asList(mapper.readValue(reader,UniteEnseignement[].class));
        return ue;

    }
}
