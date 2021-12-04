package Controller;

import Modele.Promotion;
import Service.PromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromotionController {
    private PromotionService promService = new PromotionService();

    @GetMapping("/promotions")
    public List<Promotion> getProms() {
        return promService.getProms();
    }
}
