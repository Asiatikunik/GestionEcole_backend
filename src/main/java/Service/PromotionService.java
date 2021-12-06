package Service;

import Modele.Promotion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PromotionService {

    public List<Promotion> getProms() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Promotion> proms = null;
        String file = "src/main/java/json/promotion.json";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            proms = Arrays.asList(mapper.readValue(reader,Promotion[].class));
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

}
