package Controller;

import Modele.Creneau;
import Service.CreneauService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CreneauController {
    private CreneauService creneauService= new CreneauService();

    @GetMapping("/creneau")
    public List<Creneau> getCreneaux() throws IOException
    {
        return creneauService.getCreneau();
    }
}
