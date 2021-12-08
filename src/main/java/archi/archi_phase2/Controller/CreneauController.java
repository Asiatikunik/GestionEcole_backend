package archi.archi_phase2.Controller;

import archi.archi_phase2.Modele.Creneau;
import archi.archi_phase2.Service.CreneauService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class CreneauController {
    private CreneauService creneauService= new CreneauService();

    @Operation(summary="Récupérer tous les créneaux")
    @GetMapping("/creneau")
    public List<Creneau> getCreneaux() throws IOException
    {
        return creneauService.getCreneaux();
    }

    @Operation(summary="Récupérer un créneau")
    @GetMapping("/creneau/{date}/{debut}/{fin}")
    public Creneau getCreneau(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime debut, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime fin) throws IOException
    {
        return creneauService.getCreneau(date,debut,fin);
    }

    @Operation(summary="Ajouter un créneau")
    @PostMapping("/creneau")
    public void addCreneau(@RequestBody Creneau creneau) throws IOException {
        creneauService.addCreneau(creneau);
    }

    @Operation(summary="Supprimer un créneau")
    @DeleteMapping("/creneau")
    public void deleteCreneau(@RequestBody Creneau creneau) throws IOException {
        creneauService.deleteCreneau(creneau);
    }

    @Operation(summary="Modifier un créneau")
    @PutMapping("/creneau/{date}/{debut}/{fin}")
    public void updateCreneau(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime debut, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime fin,@RequestBody Creneau creneau) throws IOException
    {
        creneauService.updateCreneau(date,debut,fin, creneau);
    }

}
