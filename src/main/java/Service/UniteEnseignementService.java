package Service;

import Modele.UniteEnseignement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniteEnseignementService {

    public List<UniteEnseignement> getUEs() {
        List<UniteEnseignement> ues = new ArrayList<>();
        ues.add(new UniteEnseignement("sigle","nom"));

        return ues;

    }
}
