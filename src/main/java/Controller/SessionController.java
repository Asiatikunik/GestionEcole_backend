package Controller;

import Modele.Session;
import Service.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SessionController {
    private SessionService sessionService = new SessionService();

    @GetMapping("/session")
    public List<Session> getSessions() throws IOException {
        return sessionService.getSessions();
    }
}
