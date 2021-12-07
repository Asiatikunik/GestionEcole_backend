package archi.archi_phase2.Controller;

import archi.archi_phase2.Modele.Creneau;
import archi.archi_phase2.Service.CreneauService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class CreneauController {
    private CreneauService creneauService= new CreneauService();

    @GetMapping("/creneau")
    public List<Creneau> getCreneaux() throws IOException
    {
        return creneauService.getCreneaux();
    }

    @GetMapping("/creneau/{date}/{debut}/{fin}")
    public Creneau getCreneau(@PathVariable LocalDate date, @PathVariable LocalTime debut, @PathVariable LocalTime fin) throws IOException
    {
        return creneauService.getCreneau(date,debut,fin);
    }

    @PostMapping("/creneau")
    public void addCreneau(@RequestBody Creneau creneau) throws IOException {
        creneauService.addCreneau(creneau);
    }
}
