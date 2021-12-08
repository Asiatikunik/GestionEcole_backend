package archi.archi_phase2.Controller;


import archi.archi_phase2.Modele.Promotion;
import archi.archi_phase2.Modele.UniteEnseignement;
import archi.archi_phase2.Service.UniteEnseignementService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UniteEnseignementController {

    private UniteEnseignementService ueService;

    public UniteEnseignementController(UniteEnseignementService ueService) {
        this.ueService = ueService;
    }

    @Operation(summary="Récupérer toutes les unités d'enseignement")
    @GetMapping("/ue")
    public List<UniteEnseignement> getUEs() throws IOException {
        return ueService.getUEs();
    }

    @Operation(summary="Récupérer une unité d'enseignement")
    @GetMapping("/ue/{sigle}")
    public UniteEnseignement getUEById(@PathVariable String sigle) throws IOException {
        return ueService.getUEByName(sigle);
    }

    @Operation(summary="Ajouter une unité d'enseignement")
    @PostMapping("/ue")
    public void addUe(@RequestBody UniteEnseignement ue) throws IOException {
        ueService.addUe(ue);
    }

    @Operation(summary="Supprimer une unité d'enseignement")
    @DeleteMapping("/ue/{nom}")
    public void deleteUe(@PathVariable String nom) throws IOException
    {
        ueService.deleteUe(nom);
    }

    @Operation(summary="Modifier une unité d'enseignement")
    @PutMapping("/ue/{sigle}")
    public void updateUe(@PathVariable String sigle, @RequestBody UniteEnseignement ue) throws IOException
    {
        ueService.updateUe(sigle, ue);
    }
}
