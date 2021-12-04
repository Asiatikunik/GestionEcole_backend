package Service;

import Modele.Promotion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionService {

    public List<Promotion> getProms() {
        List<Promotion> proms = new ArrayList<>();
        proms.add(new Promotion(3,"IATIC5"));

        return proms;
    }
}
