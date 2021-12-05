package Service;

import Modele.Creneau;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
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
    public List<Creneau> getCreneaux() throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/json/creneau.json"));

        List<Creneau> creneaux = Arrays.asList(mapper.readValue(reader, Creneau[].class));

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
