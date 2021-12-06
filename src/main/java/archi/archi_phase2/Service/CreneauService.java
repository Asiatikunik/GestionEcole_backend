package archi.archi_phase2.Service;

import archi.archi_phase2.Modele.Creneau;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CreneauService {
    public List<Creneau> getCreneaux() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Creneau> creneaux = null;
        String file = "src/main/resources/json/creneau.json";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            creneaux = Arrays.asList(mapper.readValue(reader, Creneau[].class));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return creneaux;
    }

    public Creneau getCreneau(LocalDate date, LocalTime debut, LocalTime fin) throws IOException {
        List<Creneau> listCreneaux = getCreneaux();
        for(Creneau creneau : listCreneaux)
        {
            if((creneau.getDate().equals(date)) && (creneau.getDebut().equals(debut)) && (creneau.getFin().equals(fin)))
            {
                return creneau;
            }
        }
        return null;
    }
}