package archi.archi_phase2.Controller;


import archi.archi_phase2.Modele.Promotion;
import archi.archi_phase2.Modele.UniteEnseignement;
import archi.archi_phase2.Service.UniteEnseignementService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UniteEnseignementController {

    private UniteEnseignementService ueService;

    public UniteEnseignementController(UniteEnseignementService ueService) {
        this.ueService = ueService;
    }

    @GetMapping("/ue")
    public List<UniteEnseignement> getUEs() throws IOException {
        return ueService.getUEs();
    }

    @GetMapping("/ue/{sigle}")
    public UniteEnseignement getUEById(@PathVariable String sigle) throws IOException {
        return ueService.getUEByName(sigle);
    }

    @PostMapping("/ue")
    public void addUe(@RequestBody UniteEnseignement ue) throws IOException {
        ueService.addUe(ue);
    }

    @DeleteMapping("/ue")
    public void deleteUe(@RequestBody UniteEnseignement ue) throws IOException
    {
        ueService.deleteUe(ue);
    }

}
