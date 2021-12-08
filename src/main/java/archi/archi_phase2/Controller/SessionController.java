package archi.archi_phase2.Controller;

import archi.archi_phase2.Modele.Session;
import archi.archi_phase2.Service.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class SessionController {
    private SessionService sessionService = new SessionService();

    @Operation(summary="Récupérer toutes les sessions")
    @GetMapping("/session")
    public List<Session> getSessions() throws IOException {
        return sessionService.getSessions();
    }

    @Operation(summary="Récupérer une session")
    @GetMapping("/session/{sigle}/{nom}/{date}/{debut}/{fin}")
    public Session getSession(@PathVariable String sigle, @PathVariable String nom, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime debut, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime fin) throws IOException {
        return sessionService.getSessionBy(sigle,nom,date,debut,fin);
    }

    @Operation(summary="Ajouter une session")
    @PostMapping("/session")
    public void addSession(@RequestBody Session session) throws IOException {
        sessionService.addSession(session);
    }

    @Operation(summary="Supprimer une session")
    @DeleteMapping("/session")
    public void deleteSession(@RequestBody Session session) throws IOException
    {
        sessionService.deleteSession(session);
    }

    @Operation(summary="Modifier une session")
    @PutMapping("/session/{sigle}/{nom}/{date}/{debut}/{fin}")
    public void updateSession(@PathVariable String sigle, @PathVariable String nom, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime debut, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime fin, @RequestBody Session session) throws IOException {
        sessionService.updateSession(sigle,nom,date,debut,fin,session);
    }
}
