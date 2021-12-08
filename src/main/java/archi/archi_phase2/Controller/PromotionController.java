package archi.archi_phase2.Controller;

import archi.archi_phase2.Modele.Promotion;
import archi.archi_phase2.Service.PromotionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
public class PromotionController {
    private PromotionService promService = new PromotionService();


    @Operation(summary="Récupérer toutes les promotions")
    @ApiResponse(responseCode="200",
            description="Fetch all Promotions",
            content= {@Content(mediaType = "application/json")})
    @GetMapping("/promotion")
    public List<Promotion> getProms() throws IOException {
        return promService.getProms();
    }

    @Operation(summary="Récupérer une promotion")
    @GetMapping("/promotion/{nom}")
    public Promotion getPromByName(@PathVariable String nom) throws IOException {
        return promService.getPromByName(nom);
    }

    @Operation(summary="Ajouter une nouvelle promotion")
    @PostMapping("/promotion")
    public void addProm(@RequestBody Promotion prom) throws IOException {
        promService.addProm(prom);
    }

    @Operation(summary="Supprimer une promotion")
    @DeleteMapping("/promotion")
    public void deleteProm(@RequestBody Promotion promotion) throws IOException
    {
        promService.deleteProm(promotion);
    }

    @Operation(summary="Modifier une promotion")
    @PutMapping("/promotion/{nom}")
    public void updateProm(@PathVariable String nom, @RequestBody Promotion promotion) throws IOException
    {
        promService.updatePromotion(nom, promotion);
    }
}
