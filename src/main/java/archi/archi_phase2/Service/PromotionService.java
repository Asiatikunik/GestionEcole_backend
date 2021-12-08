package archi.archi_phase2.Service;

import archi.archi_phase2.Modele.Promotion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PromotionService {
    private String filename = "src/main/resources/json/promotion.json";

    public List<Promotion> getProms() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Promotion> proms = null;


        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            proms = new ArrayList<>(Arrays.asList(mapper.readValue(reader,Promotion[].class)));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return proms;
    }

    public Promotion getPromByName(String nom) throws IOException {
        List<Promotion> proms = getProms();
        for(Promotion prom : proms)
        {
            if(prom.getNom().equals(nom))
            {
                return prom;
            }
        }
        return null;

    }

    public void addProm(Promotion prom) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Promotion> proms = getProms();
        proms.add(prom);
        String json = mapper.writeValueAsString(proms);

        FileWriter fw = new FileWriter(new File(filename));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();
    }

    /*public void deleteProm(String nom) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Promotion> proms = getProms();
        System.out.println(proms);
        proms.removeIf(prom -> (prom.getNom().equals(nom)));
        System.out.println(proms);
        String json = mapper.writeValueAsString(proms);

        FileWriter fw = new FileWriter(new File(filename));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();

    }*/

    public void deleteProm(Promotion promotion) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Promotion> proms = getProms();
        System.out.println(proms);
        proms.removeIf(prom -> prom.isEqual(promotion));
        System.out.println(proms);
        String json = mapper.writeValueAsString(proms);

        FileWriter fw = new FileWriter(new File(filename));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();
    }


}
