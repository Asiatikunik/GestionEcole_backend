package Controller;

import Modele.Session;
import Service.SessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
