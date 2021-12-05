package Service;

import Modele.Creneau;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class CreneauService {

    public List<Creneau> getCreneau() throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/json/creneau.json"));

        List<Creneau> creneaux = Arrays.asList(mapper.readValue(reader, Creneau[].class));

        return creneaux;
    }
}
