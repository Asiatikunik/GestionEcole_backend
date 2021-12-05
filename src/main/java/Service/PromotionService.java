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
        //List<Promotion> proms = new ArrayList<>();
        //proms.add(new Promotion(3,"IATIC5"));
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/json/promotion.json"));

        List<Promotion> proms = Arrays.asList(mapper.readValue(reader,Promotion[].class));

        return proms;
    }
}
