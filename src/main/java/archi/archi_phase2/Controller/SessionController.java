package archi.archi_phase2.Controller;

import archi.archi_phase2.Modele.Session;
import archi.archi_phase2.Service.SessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class SessionController {
    private SessionService sessionService = new SessionService();

    @GetMapping("/session")
    public List<Session> getSessions() throws IOException {
        return sessionService.getSessions();
    }

    @GetMapping("/session/{sigle}/{nom}/{date}/{debut}/{fin}")
    public Session getSession(@PathVariable String sigle, @PathVariable String nom, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime debut, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime fin) throws IOException {
        return sessionService.getSessionBy(sigle,nom,date,debut,fin);
    }

    @PostMapping("/session")
    public void addSession(@RequestBody Session session) throws IOException {
        sessionService.addSession(session);
    }

    @DeleteMapping("/session")
    public void deleteSession(@RequestBody Session session) throws IOException
    {
        sessionService.deleteSession(session);
    }
}
