package archi.archi_phase2.Service;

import archi.archi_phase2.Modele.Creneau;
import archi.archi_phase2.Modele.Promotion;
import archi.archi_phase2.Modele.UniteEnseignement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CreneauService {

    private String filename = "src/main/resources/json/creneau.json";

    public List<Creneau> getCreneaux() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Creneau> creneaux = null;
        String file = "src/main/resources/json/creneau.json";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            creneaux = new ArrayList<>(Arrays.asList(mapper.readValue(reader, Creneau[].class)));
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

    public void addCreneau(Creneau creneau) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Creneau> creneaux = getCreneaux();
        creneaux.add(creneau);
        String json = mapper.writeValueAsString(creneaux);

        FileWriter fw = new FileWriter(new File(filename));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();
    }

    public void deleteCreneau(Creneau creneau) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Creneau> creneaux = getCreneaux();
        System.out.println(creneaux);
        creneaux.removeIf(cren ->(cren.equals(creneau)));
        System.out.println(creneaux);
        String json = mapper.writeValueAsString(creneaux);

        FileWriter fw = new FileWriter(new File(filename));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();

    }

    public void updateCreneau(LocalDate date, LocalTime debut, LocalTime fin, Creneau creneau) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Creneau> creneaux = getCreneaux();
        int index = creneaux.indexOf(getCreneau(date,debut,fin));
        System.out.println(getCreneau(date,debut,fin));
        System.out.println(creneau);
        System.out.println(creneaux);
        creneaux.set(index, creneau);
        System.out.println(creneaux);
        String json = mapper.writeValueAsString(creneaux);

        FileWriter fw = new FileWriter(new File(filename));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();
    }

}
