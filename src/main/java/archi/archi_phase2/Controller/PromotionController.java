package archi.archi_phase2.Controller;

import archi.archi_phase2.Modele.Promotion;
import archi.archi_phase2.Service.PromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PromotionController {
    private PromotionService promService = new PromotionService();

    @GetMapping("/promotion")
    public List<Promotion> getProms() throws IOException {
        return promService.getProms();
    }

    @GetMapping("/promotion/{nom}")
    public Promotion getPromByName(@PathVariable String nom) throws IOException {
        return promService.getPromByName(nom);
    }
}
